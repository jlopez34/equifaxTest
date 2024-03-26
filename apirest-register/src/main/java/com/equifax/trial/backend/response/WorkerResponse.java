package com.equifax.trial.backend.response;

import com.equifax.trial.backend.helper.ResultHelper;
import com.equifax.trial.backend.model.Worker;
import com.equifax.trial.backend.response.model.Result;

import java.io.Serializable;
import java.util.List;

public class WorkerResponse implements Serializable {

    private List<Result> results;

    public List<Result> getWorkers() {
        return results;
    }

    public void setWorkers(List<Worker> workers) {
        this.results = ResultHelper.convertWorkerToResult(workers);
    }
}
