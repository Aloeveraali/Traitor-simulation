package LAB1;


import java.util.Random;

public class TraitorSimulation {
    static final int TOTAL_PARTICIPANTS = 22; // Defines constant for the total number of participants in the game - 22
    Random random = new Random(); // Used to generate random numbers

    public static void main(String[] args) {
        TraitorSimulation simulation = new TraitorSimulation();
        int nTraitors = 8;

        double probability = simulation.runSimulation(nTraitors, 10000);
        // Run 10,000 simulations
        // Call runSimulation method with the number of traitors and the number of iterations (10,000)
        // to perform Monte Carlo simulation. It stores the calculated probability of traitors winning in the variable 'probability'
        System.out.println("Probability of traitors winning with " + nTraitors + " traitors: " + probability);
    }

    double runSimulation(int nTraitors, int iterations) { // Takes numbers of iterations and traitors and returns probability of traitors winning as double
        int traitorWins = 0;

        for (int i = 0; i < iterations; i++) {
            if (simulateGame(nTraitors)) {
                traitorWins++;
            }
        }
        return (double) traitorWins / iterations;
        // Probability of traitors winning by dividing the number of traitor wins by the total number of iterations
    }

    boolean simulateGame(int nTraitors) {
        int nFaithful = TOTAL_PARTICIPANTS - nTraitors; // Calculates the number of faithful
        int total = TOTAL_PARTICIPANTS; // Keeps track of the current number
        // of players remaining as the game progresses and participants are eliminated

        while (total > 2) { // Loop continues to run as long as there are more than 2 participants in the game
            // Simulates one night where one participant is eliminated

            if (randomElimination(nTraitors,total))
            //// Generates a random integer between '0' and 'total', 
            //representing the index of the participant to be eliminated
            // 'total' represents the current number of participants left in the game
            {
                nTraitors--;
            }
            else 
            {
                nFaithful--;

                total--;
            }

            if (total <= 2) {
               return  !(nTraitors == 0 || nFaithful == 2);
            }
        }
        return false; 
    }
   
    
        boolean randomElimination(int nTraitors, int total) {
        
        int eliminated=random.nextInt(total);
        return eliminated<nTraitors;
    }

    
    }
 /* simulates ramdom elimnation process,returns true of a traitor is elminated
determines if a randomly selected individual from a group is a traitor.
nTraitors The number of traitors in the group.
total The total number of individuals in the group.
return true if the randomly selected individual is a traitor, false otherwise.
Assumes traitors are indexed from 0 to nTraitors-1 in the group.
boolean randomElimination(int nTraitors,int total)  */