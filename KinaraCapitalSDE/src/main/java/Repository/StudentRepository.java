package Repository;
import java.awt.print.Pageable;

import org.springframework.stereotype.Repository;

import model.FilterCriteria;
import model.Student;
import org.springframework.stereotype.Repository;
@Repository
@bean
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // repository methods
    @Query("SELECT s FROM Student s WHERE (:#{#filterCriteria.id} IS NULL OR s.id = :#{#filterCriteria.id}) " +
            "AND (:#{#filterCriteria.name} IS NULL OR s.name = :#{#filterCriteria.name}) " +
            "AND (:#{#filterCriteria.totalMarks} IS NULL OR s.totalMarks = :#{#filterCriteria.totalMarks})")
    Page<Student> findAllByFilterCriteria(FilterCriteria filterCriteria, Pageable pageable);

    
	static void save(Student student1) {
		// TODO Auto-generated method stub
		
	}
}
