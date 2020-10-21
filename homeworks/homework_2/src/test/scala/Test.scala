import utest._
import java.math

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33,
                35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93,
                96, 98, 99))
        }
        'test_divBy3Or5 - {
            assert(Exercises.divBy3Or5(1, 5) == Seq(3, 5))
            assert(Exercises.divBy3Or5(5, 10) == Seq(5, 6, 9, 10))
        }
        'test_sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(0, 1) == 0)
            assert(Exercises.sumOfDivBy3Or5(1, 10) == 33)
            assert(Exercises.sumOfDivBy3Or5(14, 16) == 15)
            assert(Exercises.sumOfDivBy3Or5(-15, 15) == 0)
            assert(Exercises.sumOfDivBy3Or5(1, 1000000) == 1405932684)
        }
        'passage - {
            assert(Exercises.passage(80) == Seq(2,2,2,2,5))
        }
        'primeFactor - {
            assert(Exercises.primeFactor(5) == Seq(5))
            assert(Exercises.primeFactor(10) == Seq(2,5))
            assert(Exercises.primeFactor(80) == Seq(2,5))
            assert(Exercises.primeFactor(1405932) == Seq(2, 3, 11, 10651))
        }
        'round2 - {
            assert(Exercises.round2(3.9999) == 4.00)
        }
        'abs - {
            assert(Exercises.round2(Exercises.abs(Exercises.Vector2D(2, 2*Math.sqrt(3)))) == 4.00)
        }
        'scalar - {
            assert(Exercises.round2(Exercises.scalar(Exercises.Vector2D(2,0),
                Exercises.Vector2D(2,2*Math.sqrt(3)))) == 4.00)
        }
        'cosBetween - {
            assert(Exercises.round2(Exercises.cosBetween(Exercises.Vector2D(2,0),
                Exercises.Vector2D(2,2*Math.sqrt(3)))) == 0.5)
        }
        'sumScalars - {
            assert(Exercises.sumScalars(Exercises.Vector2D(2,0), Exercises.Vector2D(2,2*Math.sqrt(3)),
                Exercises.Vector2D(2,0), Exercises.Vector2D(2,2*Math.sqrt(3))) == 8.00)
        }
        'sumCosines - {
            assert(Exercises.round2(Exercises.sumCosines(Exercises.Vector2D(2,0), Exercises.Vector2D(2,2*Math.sqrt(3)),
                Exercises.Vector2D(2,0), Exercises.Vector2D(2,2*Math.sqrt(3)))) == 1.00)
        }
        'getWeigth - {
            assert(Exercises.round2(Exercises.getWeight(2, 10.50)) == 351.86)
        }
        'sortByHeavyweight - {
            val res = Exercises.sortByHeavyweight(Exercises.balls)
            assert(res.head == "Tin")
            //Проверка последовательности
            for (i <- 0 to res.length - 2){
                assert(Exercises.getWeight(Exercises.balls.get(res.apply(i)).toSeq.head._1,
                    Exercises.balls.get(res.apply(i)).toSeq.head._2) <
                  Exercises.getWeight(Exercises.balls.get(res.apply(i+1)).toSeq.head._1,
                      Exercises.balls.get(res.apply(i+1)).toSeq.head._2))
            }
        }
    }
}
