package infy.assignment.retailer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import infy.assignment.retailer.repository.RecordRepository;
import infy.assignment.retailer.model.Record;

@Service
public class RecordService {

  @Autowired
  private RecordRepository recordRepository;

  public List<Record> getAllRecords() {
    return recordRepository.findAll();
  }

  /*
   * public record getRecordById(int id) { return recordRepository.findById(id).orElse(null); }
   * 
   * public Record saveRecord(Record record) { return recordRepository.save(record); }
   * 
   * public void deleteRecord(Long id) { recordRepository.deleteById(id); }
   */

}
