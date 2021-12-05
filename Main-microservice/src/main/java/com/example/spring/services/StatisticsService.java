package com.example.spring.services;

import ch.qos.logback.classic.Logger;
import com.example.spring.dtos.StatisticsDTO;
import com.example.spring.interfaces.*;
import com.example.spring.models.Checker;
import com.example.spring.models.Clocker;
import com.example.spring.models.Counter;
import com.example.spring.properties.ReaderFile;
import com.example.spring.properties.WriterFile;
import com.example.spring.repository.StatisticsRepository;
import org.json.simple.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StatisticsService {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(StatisticsService.class);
    StatisticsDTO statisticsDTO = new StatisticsDTO();
    ReadingFile readingFile = new ReaderFile();
    Checking checking = new Checker();
    Counting counting = new Counter();
    WritingFile writingFile = new WriterFile();
    Clocking clocking = new Clocker();

    @Autowired
    private StatisticsRepository statisticsRepository;

    @Cacheable("ehCacheStatistic")
    public String getTextFile() {
        logger.info("Read File");
        return readingFile.read();
    }

    @Cacheable("ehCacheStatistic")
    public void setResultFile(String resultFile) {
        logger.info("Write File");
        writingFile.write(resultFile);
    }

    @Cacheable("ehCacheStatistic")
    public String getResult(String textInput, String typeInput) {
        logger.info("Get Result");
        if (statisticsRepository.findByLine(textInput) == null) {
            String check = checking.determine(textInput);
            List<String> result = counting.identify(check);
            saveStatistics(result, textInput, typeInput);
        } else {
            setInspections(textInput);
        }
        return setJson(statisticsRepository.findByLine(textInput).getLine());
    }


    private void saveStatistics(List<String> rusult, String line, String typeInput) {
        logger.info("Save statistics");
        statisticsDTO.setVowelsNumber(Integer.parseInt(rusult.get(0)));
        statisticsDTO.setConsonantsNumber(Integer.parseInt(rusult.get(1)));
        statisticsDTO.setVowels(rusult.get(2));
        statisticsDTO.setConsonants(rusult.get(3));
        statisticsDTO.setLine(line);
        statisticsDTO.setTypeInput(typeInput);
        statisticsDTO.setTimestamp(String.valueOf(clocking.getTime()));
        statisticsDTO.setInspections(1);
        statisticsRepository.save(statisticsDTO);
    }

    private void setInspections(String textInput) {
        StatisticsDTO statistics = statisticsRepository.findByLine(textInput);
        int inspections = statistics.getInspections() + 1;
        statistics.setInspections(inspections);
        statisticsRepository.save(statistics);
    }

    private String setJson(String textInput) {
        JSONObject json = new JSONObject();
        json.put("line", statisticsRepository.findByLine(textInput).getLine());
        json.put("vowels_number", statisticsRepository.findByLine(textInput).getVowelsNumber());
        json.put("vowels", statisticsRepository.findByLine(textInput).getVowels());
        json.put("consonants_number", statisticsRepository.findByLine(textInput).getConsonantsNumber());
        json.put("consonants", statisticsRepository.findByLine(textInput).getConsonants());
        json.put("time", statisticsRepository.findByLine(textInput).getTimestamp());
        json.put("type_input", statisticsRepository.findByLine(textInput).getTypeInput());
        json.put("inspections", statisticsRepository.findByLine(textInput).getInspections());
        return json.toJSONString();
    }
}