package com.BazyDanych2Projekt.BazyDanychProjekt.Report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReportRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Report> getReportList() {
        return jdbcTemplate.query("SELECT * FROM report ORDER BY report_id ASC", BeanPropertyRowMapper.newInstance(Report.class));
    }

    public List<Report> getReportListBySellerId(int id) {
        return jdbcTemplate.query("SELECT * FROM report WHERE seller_id = ? ORDER BY report_id DESC", BeanPropertyRowMapper.newInstance(Report.class), id);
    }

    public Report getReportById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM report WHERE report_id = ?", BeanPropertyRowMapper.newInstance(Report.class), id);
    }

    public String saveReports(List<Report> reports) {
        reports.forEach(report -> jdbcTemplate.update("INSERT INTO report (report_id, seller_id)" +
                        "VALUES (?, ?)",
                report.getReport_id(),
                report.getSeller_id()));

        return "Success!";
    }

    public int updateReport(Report report) {
        return jdbcTemplate.update("UPDATE report SET seller_id = ? WHERE report_id = ?",
                report.getSeller_id(), report.getReport_id());
    }

    public String deleteReport(int id) {
        jdbcTemplate.update("DELETE FROM report WHERE report_id = ?", id);

        return "Success!";
    }
}
