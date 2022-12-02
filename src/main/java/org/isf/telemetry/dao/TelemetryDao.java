package org.isf.telemetry.dao;

import org.isf.telemetry.bo.TelemetryBo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TelemetryDao extends JpaRepository<TelemetryBo, Long> {

	@Query(value = "SELECT max(u.requestId) FROM telemetry u")
	Integer retrieveNextRequestId();

}

