package org.isf.telemetry.dto;

import java.util.ArrayList;
import java.util.List;

public class TelemetryInsertRequest {

	private List<KeyValue> data = new ArrayList<>();


	public List<KeyValue> getData() {
		return data;
	}


	public void setData(List<KeyValue> data) {
		this.data = data;
	}



}
