package frsf.ia.grupo1;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.examples.search.pacman.PacmanAgent;
import frsf.cidisi.faia.examples.search.pacman.PacmanEnvironment;
import frsf.cidisi.faia.examples.search.pacman.PacmanEnvironmentState;

public class PlantaPerception extends Perception {
//matrizPosiciones se representa como una matriz de 5x9. Los zombies se representar�n como z1, z2, z3, z4, z5 siendo el sub�ndice la cantidad de soles que necesita la planta para matar a ese zombie.
//	Los girasoles se representar�n con la cantidad de soles que est�n presentes en su celda (0 a 99) donde 0 se refiere a un girasol sin ning�n sol producido. La celda donde se encuentra la planta se representa como p. 
//	La letra x la utilizaremos para representar una celda la cual no tenemos informaci�n y la letra e para representar una celda vac�a. 

    public static String Z1_PERCEPTION = "z1";
    public static String Z2_PERCEPTION = "z2";
    public static String Z3_PERCEPTION = "z3";
    public static String Z4_PERCEPTION = "z4";
    public static String Z5_PERCEPTION = "z5";
    public static String GIRASOLES_PERCEPTION = "0";
    public static String UNKNOWN_PERCEPTION = "x";
    public static String EMPTY_PERCEPTION = "e";
    

    //Prueba rama
    
    private int energy;
    private String [][] rowSensor;
    private String [][] columnSensor;

    public PlantaPerception() {
    	//TODO compare to Pacman where it set the energy to 50
    }

    public PlantaPerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * This method is used to setup the perception.
     */
    @Override
    public void initPerception(Agent agent, Environment environment) {
        PacmanAgent pacmanAgent = (PacmanAgent) agent; //TODO
        AmbienteEnvironment ambienteEnvironment = (AmbienteEnvironment) environment;
        AmbienteEnvironmentState environmentState =
        		ambienteEnvironment.getEnvironmentState();


//      Cada girasol genera aleatoriamente entre 1 y 3 soles por cada ciclo de percepci�n.
//      Primero actualizamos los soles de los girasoles y despues percibimos la data actualizada
        environmentState.setSoles();
        
//        Hacer avanzar los zombies que esten ya presentes 
//        Tenemos que ver como modelar esto:
//        Un zombie puede demorar entre 1 y 3 ciclos de percepci�n de manera aleatoria para avanzar a la siguiente celda
//        Como podemos llevar registro de hace cuanto tiempo se movio el zombie???
       
        
//        Hacer aparecer nuevos Zombies unicamente si la ultima columna no esta completa por zombies
//        podemos hacer aparecer un numero random entre la cantidad de celdas libres en la ultima columna
//        hasta 5(max numero de filas) o cantidad de zombies que todavia no hicimos aparecer, el numero que sea menor
//        environmentState.setZombies();
        
        int row = environmentState.getAgentPosition()[0];
        int col = environmentState.getAgentPosition()[1];
        
        this.setRowSensor(ambienteEnvironment.getRow(row));
        this.setColumnSensor(ambienteEnvironment.getColumn(col));
       
    }

    public void setRowSensor(String [][] rowSensor) {
        this.rowSensor = rowSensor;
    }
    
    public String [][] getRowSensor() {
        return rowSensor;
    }
    
    public void setColumnSensor(String [][] columnSensor) {
        this.columnSensor = columnSensor;
    }
    
    public String [][] getColumnSensor() {
        return columnSensor;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

}
