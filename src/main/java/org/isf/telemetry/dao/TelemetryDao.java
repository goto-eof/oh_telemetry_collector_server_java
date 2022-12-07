package org.isf.telemetry.dao;

import java.util.List;

import org.isf.telemetry.bean.KeyValue;
import org.isf.telemetry.bo.TelemetryBo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TelemetryDao extends JpaRepository<TelemetryBo, Long> {

	@Query(value = "SELECT max(u.requestId) FROM telemetry u")
	Integer retrieveNextRequestId();

	@Query("select new org.isf.telemetry.bean.KeyValue(count(t1.value) as key, t1.value as value) "
					+ ""
					+ "from telemetry t1 "
					+ "where t1.key = :keyMemory"
					+ "		 and t1.requestId in ("
					+ "							select max(t2.requestId)"
					+ "							from   telemetry t2"
					+ "							where  t2.key = :keyHwId"
					+ "							group by t2.key, t2.value"
					+ "							) "
					+ "group by t1.code, t1.key, t1.value "
					+ "order by key desc")
	List<KeyValue> countAndRetrieve(@Param("keyMemory") String keyMemory, @Param("keyHwId") String keyHwId);

}
