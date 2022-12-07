package org.isf.telemetry.controller;

import java.util.List;
import java.util.Map;

import org.isf.telemetry.bean.KeyValue;
import org.isf.telemetry.dto.TelemetryGenericResponse;
import org.isf.telemetry.service.TelemetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TelemetryController {

	@Autowired
	private TelemetryService telemetryservice;

	@PostMapping("/collect")
	public ResponseEntity<TelemetryGenericResponse<Boolean>> storeData(@RequestBody Map<String, Map<String, String>> data) {
		return  ResponseEntity.ok(this.telemetryservice.storeData(data));
	}


	@GetMapping("/num-comp-ram")
	public ResponseEntity<List<KeyValue>> retrieveComputersAndRam() {
		return  ResponseEntity.ok(this.telemetryservice.retrieveComputersAndRam());
	}

}
