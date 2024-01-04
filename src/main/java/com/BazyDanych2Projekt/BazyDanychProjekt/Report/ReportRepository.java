package com.BazyDanych2Projekt.BazyDanychProjekt.Report;

import com.BazyDanych2Projekt.BazyDanychProjekt.Underwear.Underwear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
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
}
