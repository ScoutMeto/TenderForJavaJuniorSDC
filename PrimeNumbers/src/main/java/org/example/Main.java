package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {

        if (args.length == 1) {
            String fileName = args[0];
            PrimeNumberProcesser.importExcel(fileName);
            PrimeNumberProcesser.sortExcelData();
            PrimeNumberProcesser.notePrimeNumber();
            PrimeNumberProcesser.generateData();
        } else {
            logger.error("Wrong parameters.");
            throw new IOException();
        }

    }
}

/*
Task at hand:
V programovacím jazyce Java s využitím Mavenu vytvořte program, který bude spouštěný z příkazové řádky.
Jako jediný vstupní parametr bude mít zadaný datovy soubor.
Program vypíše všechna prvočisla nalezená v datovém souboru (jeden řadek vystupu = jedno nalezené prvočíslo) v pořadí, v jakém se v souboru vyskytují.
Pro výstup bude použit Logger.
Je možné používat jakékoli volně dostupné knihovny.

Program by měl obsahovat JUnit testy funkcionality.

Vystup včetně zdrojových kódů prosím nahrát na github (případně zaslat zip se zdrojovými soubory).

Popis datového souboru:
Datovy soubor je ve formatu Excel 2007-2013 (xlsx).
Data jsou v prvním listu ve sloupci B.
Validní data jsou pouze kladná cela čísla, nevalidní data by měl program ignorovat.
Malý VZOREK dat je přílohou zadaní, jedna se opravdu o vzorek, finalni data mohou byt jina!
Může jich být více a větší, s vlivem na cekový výkon výpočtu.
 */
