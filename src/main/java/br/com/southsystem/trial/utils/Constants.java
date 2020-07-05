/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.southsystem.trial.utils;

import java.io.File;

/**
 *
 * @author vinif
 */
public class Constants {
    public static final String MAIN_DIRECTORY_PATH = System.getenv("HOMEPATH")
            .concat(File.separator)
            .concat("data");

    public static final String IN_DIRECTOTY_PATH = MAIN_DIRECTORY_PATH
            .concat(File.separator)
            .concat("in")
            .concat(File.separator);

    public static final String OUT_DIRECTOTY_PATH = MAIN_DIRECTORY_PATH
            .concat(File.separator)
            .concat("out")
            .concat(File.separator);
}
