package app.ui.console;

import app.ui.console.utils.Utils;
import org.junit.jupiter.api.DisplayNameGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class LegacyDataUI implements Runnable {
private LoadLegacyDataController ctrl;
SimpleDateFormat horas;
public LegacyDataUI() {
    this.ctrl = new LoadLegacyDataController();
    this.horas = new SimpleDateFormat("HH:mm");
}

}
