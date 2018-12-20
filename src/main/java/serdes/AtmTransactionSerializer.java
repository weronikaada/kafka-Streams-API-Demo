package serdes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
import myapps.ATMFraud.AtmTransaction;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

//@Slf4j
public class AtmTransactionSerializer implements Serializer<AtmTransaction> {

  private ObjectMapper mapper = new ObjectMapper();

  @Override
  public void configure(Map<String, ?> configs, boolean isKey) {
    //nothing to do.
  }

  @Override
  public byte[] serialize(String topic, AtmTransaction transaction) {
    byte[] bytes = new byte[0];

    try {
//      System.out.println("Incoming object : " + transaction == null ? transaction : transaction.toString());
      bytes = mapper.writeValueAsString(transaction).getBytes();
    } catch (JsonProcessingException e) {
      System.out.println("Error serializing atm transaction.");
      e.printStackTrace();
    }

    return bytes;
  }

  @Override
  public void close() {
    //nothing to do.
  }
}
