package org.isf.telemetry.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.isf.telemetry.bean.KeyValue;
import org.isf.telemetry.converter.TelemetryConverter;
import org.isf.telemetry.dao.TelemetryDao;
import org.isf.telemetry.dto.TelemetryGenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TelemetryService {

	private static final String KEY_CPU_ID = "key.cpu_id";
	private static final String KEY_TOTAL_MEMORY = "key.total_memory";

	@Autowired
	private TelemetryDao telemetryDao;

	@Autowired
	public EntityManager entityManager;

	@Autowired
	private Environment env;

	@Autowired
	private TelemetryConverter telemetryConverter;

	public TelemetryGenericResponse<Boolean> storeData(Map<String, Map<String, String>> telemetryInsertRequest) {
		final int generatedValue = Optional.ofNullable(this.telemetryDao.retrieveNextRequestId()).orElse(0) + 1;

		telemetryInsertRequest.forEach((code, map) -> {
			map.forEach((key, value) -> {
				this.telemetryDao.save(this.telemetryConverter.toBo(code, key, value, generatedValue));
			});

		});

		return new TelemetryGenericResponse<Boolean>(true, true);
	}

	public List<KeyValue> retrieveComputersAndRam() {
		return this.telemetryDao.countAndRetrieve(env.getProperty(KEY_TOTAL_MEMORY), env.getProperty(KEY_CPU_ID));
	}

}
