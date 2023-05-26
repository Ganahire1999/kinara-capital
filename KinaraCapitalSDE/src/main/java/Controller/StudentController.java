package Controller;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import model.FilterCriteria;
import model.Student;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        try {
            CSVReader reader = new CSVReader
            		(new FileReader(new ClassPathResource("students.csv").getFile()));
            List<String[]> studentData = reader.readAll();

            int startIndex = (page - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, studentData.size());

            List<Student> students = new ArrayList<>();
            for (int i = startIndex; i < endIndex; i++) {
                String[] row = studentData.get(i);
                Student student = new Student
                		(Integer.parseInt(row[0]), row[1], Integer.parseInt(row[2]));
                students.add(student);
            }

            return ResponseEntity.ok(students);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    //2nd mapping 

    @PostMapping("/students/filter")
    public ResponseEntity<List<Student>> filterStudents(@RequestBody FilterCriteria filterCriteria,
                                                        @RequestParam(defaultValue = "1") int page,
                                                        @RequestParam(defaultValue = "10") int pageSize) {
        try {
            CSVReader reader = new CSVReader(new FileReader(new ClassPathResource("students.csv").getFile()));
            List<String[]> studentData = reader.readAll();

            List<Student> filteredStudents = new ArrayList<>();
            for (String[] row : studentData) {
                int id = Integer.parseInt(row[0]);
                String name = row[1];
                int totalMarks = Integer.parseInt(row[2]);

                // Apply filters based on criteria
                if (filterCriteria.getId() == null || filterCriteria.getId() == id) {
                    if (filterCriteria.getName() == null || filterCriteria.getName().equals(name)) {
                        if (filterCriteria.getTotalMarks() == null || filterCriteria.getTotalMarks() == totalMarks) {
                            Student student = new Student(id, name, totalMarks);
                            filteredStudents.add(student);
                        }
                    }
                }
            }

            int startIndex = (page - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, filteredStudents.size());
            
            // arraylist use

            List<Student> paginatedStudents = filteredStudents.subList(startIndex, endIndex);
            return ResponseEntity.ok(paginatedStudents);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}


