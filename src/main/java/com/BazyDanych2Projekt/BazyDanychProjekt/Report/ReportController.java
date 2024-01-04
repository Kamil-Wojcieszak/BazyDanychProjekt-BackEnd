package com.BazyDanych2Projekt.BazyDanychProjekt.Report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    ReportRepository reportRepository;

    @GetMapping("/list")
    public List<Report> getReportList() {
        return reportRepository.getReportList();
    }

    @GetMapping("/seller/{id}")
    public List<Report> getReportListBySellerId(@PathVariable("id") int id) {
        return reportRepository.getReportListBySellerId(id);
    }
}
