package frsf.ia.grupo1;

import frsf.cidisi.faia.state.EnvironmentState;

public class AmbienteEnvironmentState extends EnvironmentState {

    private String[][] world;
    private int[] agentPosition;
    private int agentEnergy;
    private int totalZombies;

    public AmbienteEnvironmentState(String[][] m) {
        world = m;
    }

    public AmbienteEnvironmentState() {
        world = new String[5][9];
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {

        // Sets all cells as empty
        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world.length; col++) {
                world[row][col] = PlantaPerception.EMPTY_PERCEPTION;
            }
        }

        /* Sets some cells with enemies. */
//        Los zombies aparecen aleatoriamente en el escenario. La cantidad es aleatoria
//        entre 5 y 20 y se determina al inicio del juego. - 
        int numeroInicialDeZombies = getRandomNumber(5, 20);
        
//      Los zombies siempre inician en la celda mas alejada de la casa, y en el inicio del
//      juego puede que no est�n todos los zombies en el escenario, sino que se van
//      sumando a medida que transcurre el tiempo
//      Numero de zombies que aparecen al principio es random, no puede haber mas de 5 porque como los
//        zombies aparecen siempre lo mas alejado tiene que ser en la ultima columna.
//        TODO a menos que sea en la celda LIBRE  mas alejada de la casa? pero para mi esto nos complica
        
        int zombiesInicio = getRandomNumber(1,5);
        
//      Set los primeros x zombies en la ultima columna empezando desde la row 0, el tipo de zombie que toca en casa posicion tambien es random
        
        for(int i=0;i<zombiesInicio;i++){
        	int tipoDeZombie = getRandomNumber(1, 5);
        	switch(tipoDeZombie) {
        	case 1:
        		world[i][8] = PlantaPerception.Z1_PERCEPTION;
        		break;
        	case 2:
        		world[i][8] = PlantaPerception.Z2_PERCEPTION;
        		break;
        	case 3:
        		world[i][8] = PlantaPerception.Z3_PERCEPTION;
        		break;
        	case 4:
        		world[i][8] = PlantaPerception.Z4_PERCEPTION;
        		break;
        	case 5:
        		world[i][8] = PlantaPerception.Z5_PERCEPTION;
        		break;
        	}
        }
        
        this.setTotalZombies(numeroInicialDeZombies);
        this.setAgentPosition(new int[]{2, 1});
//        En el inicio la planta recibe una cantidad aleatoria de entre 2 y 20 soles. 
        int energiaInicial = getRandomNumber(2, 20);
        this.setAgentEnergy(energiaInicial);
    }
    
    
    

    public String[][] getWorld() {
        return world;
    }

    public void setWorld(String[][] world) {
        this.world = world;
    }

    public void setWorld(int row, int col, String value) {
        this.world[row][col] = value;
    }
    
    public void setSoles() {
    	//Check where we have a girasol and generate soles with random function from 1 till 3
    	
    	for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world.length; col++) {
            	//basically if we dont have a zombie, the plant or empty then we have a girasol(integer number)
            	if(!world[row][col].contains("z") || !world[row][col].contains("x") || !world[row][col].contains("e")) {
            		int numeroDeSoles = Integer.parseInt(world[row][col]);
            		int nuevosSoles = getRandomNumber(1,3);
            		
            		world[row][col]=Integer.toString(numeroDeSoles + nuevosSoles);
            
            	}
            }
        }
    }

    public int[] getAgentPosition() {
        return agentPosition;
    }

    public void setAgentPosition(int[] agentPosition) {
        this.agentPosition = agentPosition;
    }

    public int getAgentEnergy() {
        return agentEnergy;
    }

    public void setAgentEnergy(int agentEnergy) {
        this.agentEnergy = agentEnergy;
    }
    
    public int getTotalZombies() {
        return agentEnergy;
    }

    public void setTotalZombies(int totalZombies) {
        this.totalZombies = totalZombies;
    }
    
    public String [][] getRow(int row) {
    	String [][] aux = new String[1][8];
    	for(int i=0;i<8;i++) {
    		aux[1][i]=world[row][i];
    	}
    	return aux;
	}
    
    public String [][] getColumn(int col) {
    	String [][] aux = new String[5][1];
    	for(int i=0;i<8;i++) {
    		aux[i][1]=world[i][col];
    	}
    	return aux;
	}
    
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    
    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "";

        str = str + "[ \n";
        for (int row = 0; row < world.length; row++) {
            str = str + "[ ";
            for (int col = 0; col < world.length; col++) {
                str = str + world[row][col] + " ";
            }
            str = str + " ]\n";
        }
        str = str + " ]";

        return str;
    }

}
