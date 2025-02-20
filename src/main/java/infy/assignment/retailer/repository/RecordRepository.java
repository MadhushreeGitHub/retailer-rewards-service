package infy.assignment.retailer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import infy.assignment.retailer.model.Record;

public interface RecordRepository extends JpaRepository<Record, Long> {
  @Query("SELECT r FROM Record r")
  List<Record> findAllRecords();



}
