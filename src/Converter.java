public class Converter {
        //Перевод шагов в километры
        public double distanceKm ( int sumStep){
            double distance = sumStep * 0.00075;
            return distance;
        }
        //Перевод шагов в килокалории
        double cCal ( int sumStep){
            double oneStep = 0.05;
            return sumStep * oneStep;
        }
    }


