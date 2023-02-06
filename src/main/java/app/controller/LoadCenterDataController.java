package app.controller;

import app.controller.App;
import app.domain.model.US16.CenterData;
import app.domain.model.US16.Registo;
import app.domain.model.US16.RegistoDTO;
import app.domain.model.US16.RegistoMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoadCenterDataController {

    private List<Registo> registos;
    private CenterData centerData;

    public LoadCenterDataController() {
        this(new ArrayList<>(), App.getInstance().getCompany().getCenterData());
    }

    public LoadCenterDataController(List<Registo> registos, CenterData centerData) {
        this.registos = registos;
        this.centerData = centerData;
    }


    public void load(String filePath) throws IOException {
        File file = new File(filePath);

        if(!file.exists())
            throw new FileNotFoundException("File not found\nTry again\n");



        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;
        int lineNumber = 0;
        while((line = reader.readLine()) != null){
            if(lineNumber == 0){
                String header[] = line.split(";");
                lineNumber++;
                continue;
            }

            String[] data = line.split(";");
            Registo registo = centerData.createRegisto(
                    data[0],
                    data[1],
                    data[2],
                    data[3],
                    data[4],
                    data[5],
                    data[6],
                    data[7]
            );

            registos.add(registo);
            lineNumber++;
        }
        System.out.println("BREAKPOINT");
    }

    public void saveRegistos(){
        if(!centerData.getRegistos().isEmpty())
            centerData.getRegistos().clear(); // Clear the list before adding the new registos

        for (Registo registo : registos) {
            centerData.addRegisto(registo);
        }
    }

    public List<RegistoDTO> getRegistos(){
        return RegistoMapper.mapToDTO(this.registos);
    }

}
