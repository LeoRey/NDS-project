package id.co.nds.project.demo.generators;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomerIdGenerator implements IdentifierGenerator {

  @Override
  public Serializable generate(SharedSessionContractImplementor ssci, Object object) throws HibernateException {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMM");
    String prefix = dtf.format(LocalDate.now());
    String query = String.format("SELECT id FROM customer WHERE id LIKE '%s'", prefix + '%');

    Stream<String> ids = ssci.createNativeQuery(query, String.class).stream();

    int max = ids.map(o -> ((String) o).replace(prefix, ""))
        .mapToInt(Integer::parseInt)
        .max()
        .orElse(0);

    return prefix + (max + 1);
  }

}
