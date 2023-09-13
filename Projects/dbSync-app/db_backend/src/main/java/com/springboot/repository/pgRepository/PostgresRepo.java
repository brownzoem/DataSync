package com.springboot.repository.pgRepository;

import com.springboot.entity.pgEntity.PgCustomer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;
//import org.postgresql.util.PGInterval;

@Repository
public interface PostgresRepo extends JpaRepository<PgCustomer, String> {
//    @Modifying
//    @Query(value = "With delta as (Select (output_time - input_time) as delta from customers) select min(delta.delta), avg(delta.delta), max(delta.delta) from delta", nativeQuery = true)
//    List<Double> latency();

//    @Modifying
    @Query(value = "With delta as (\n" +
            "\tSelect (output_time - input_time) as delta from customers\n" +
            ")\n" +
            "select extract(epoch from min(delta.delta)) as min_val, \n" +
            "extract(epoch from avg(delta.delta)) as avg_val, \n" +
            "extract(epoch from max(delta.delta)) as max_val," +
            "extract(epoch from (percentile_cont(.9) within group(order by delta.delta asc))) as perc from delta", nativeQuery = true)
    List<Object> min_val();

//    @Query(value = "With delta as (\n" +
//            "\tSelect (output_time - input_time) as delta from customers\n" +
//            ")\n" +
//            "select extract(epoch from avg(delta.delta)) as avg_val from delta", nativeQuery = true)
//    List<Double> avg_val();
//
//    @Query(value = "With delta as (\n" +
//            "\tSelect (output_time - input_time) as delta from customers\n" +
//            ")\n" +
//            "select extract(epoch from max(delta.delta)) as max_val from delta", nativeQuery = true)
//    List<Double> max_val();

//    @Query(value = "SELECT * FROM (SELECT min(num), ('output_time'-'input_time') AS num)")
//    Timestamp getMin();
//
//    @Query(value = "SELECT * FROM (SELECT min(num), ('output_time'-'input_time') AS num)")
//    Timestamp getMax();


}
