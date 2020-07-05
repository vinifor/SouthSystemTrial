/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.southsystem.trial.reader;

import br.com.southsystem.trial.report.Report;
import br.com.southsystem.trial.utils.Constants;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author vinif
 */
public interface ReaderInterface {

    public void readline(String line, Report report);

    default Report readDocument(String fileName) {
        Report report = new Report(fileName);
        try (Stream<String> stream = Files.lines(Paths.get(Constants.IN_DIRECTOTY_PATH.concat(fileName)))) {
            stream.forEach(line -> readline(line, report));
        } catch (IOException ex) {
            Logger.getLogger(DatReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return report;
    }

}
