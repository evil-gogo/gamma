package companies.microsoft.online_assesment.particle_velocity;

//https://algo.monster/problems/particle_velocity

class Solution {

    public static int particleVelocity(int[] particles) {
        int total_periods = 0, particles_size = particles.length;
        for (int i = 0; i < particles_size; i++) {
            int count = 0;
            while (i + 2 < particles_size && particles[i + 1] - particles[i] == particles[i + 2] - particles[i + 1]) {
                System.out.println("i " + i + " | i + 1 " + (i + 1) + " | i + 2 " + (i + 2));
                count++;
                total_periods += count;
                i++;
            }
        }
        return total_periods < 1000000000 ? total_periods : -1;
    }

    public static void main(String[] args) {
        int[] particles = {1, 3, 5, 7, 9};
        System.out.println(particleVelocity(particles));
    }
}
