package com.equifax.trial.backend.helper;

import com.equifax.trial.backend.model.Worker;
import com.equifax.trial.backend.response.model.Result;
import com.equifax.trial.backend.response.model.ResultDetail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResultHelper implements Serializable {

    public static List<Result> convertWorkerToResult(List<Worker> workers){
        List<Result> results = new ArrayList<>();
        workers.forEach(worker -> {
            Result result = new Result();
            result.setRutInput(worker.getDni());
            result.setNombreInput(worker.getName());
            ResultDetail detail = new ResultDetail();
            detail.setActive(worker.getActive());
            detail.setHireDate(worker.getHireDate().toString());
            result.setDetail(detail);
            results.add(result);
        });
        return results;
    }
}
