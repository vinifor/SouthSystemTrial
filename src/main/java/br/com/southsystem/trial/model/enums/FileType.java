/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.southsystem.trial.model.enums;

import br.com.southsystem.trial.reader.DatReader;
import br.com.southsystem.trial.reader.ReaderInterface;
import br.com.southsystem.trial.report.Report;
import com.google.common.io.Files;

/**
 *
 * @author vinif
 */
public enum FileType {
    DAT("dat") {
        @Override
        ReaderInterface createReader() {
            return new DatReader();
        }
    };

    private final String extension;

    private FileType(String extension) {
        this.extension = extension;
    }

    public static Report readDocument(String fileName) {
        String fileExtension = Files.getFileExtension(fileName);
        if (fileExtension.equals(DAT.extension)) {
            return DAT.createReader().readDocument(fileName);
        } else {
            return null;
        }
    }

    abstract ReaderInterface createReader();
}
