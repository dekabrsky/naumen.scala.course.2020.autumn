package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_example - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
        }
        'prettyBooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1(6 > 5) == "правда")
            assert(Exercises.prettyBooleanFormatter1(5 > 6) == "ложь")
            assert(Exercises.prettyBooleanFormatter1("6 > 5".isInstanceOf[String]) == "правда")
            assert(Exercises.prettyBooleanFormatter1(5) == "5")
            assert(Exercises.prettyBooleanFormatter1(5.10) == "5.1")
            assert(Exercises.prettyBooleanFormatter1("true") == "true")
        }
        'prettyBooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter2(6 > 5) == "правда")
            assert(Exercises.prettyBooleanFormatter2(5 > 6) == "ложь")
            assert(Exercises.prettyBooleanFormatter2("6 > 5".isInstanceOf[String]) == "правда")
            assert(Exercises.prettyBooleanFormatter2(5) == "5")
            assert(Exercises.prettyBooleanFormatter2(5.10) == "5.1")
            assert(Exercises.prettyBooleanFormatter2("true") == "true")
        }
        'prettyBooleanFormatter3 - {
            assert(Exercises.prettyBooleanFormatter3(6 > 5) == "правда")
            assert(Exercises.prettyBooleanFormatter3(5 > 6) == "ложь")
            assert(Exercises.prettyBooleanFormatter3("6 > 5".isInstanceOf[String]) == "правда")
            assert(Exercises.prettyBooleanFormatter3(5) == "5")
            assert(Exercises.prettyBooleanFormatter3(5.10) == "5.1")
            assert(Exercises.prettyBooleanFormatter3("true") == "true")
        }
        'max1 - {
            assert(Exercises.max1(Seq(1, 2, 3)) == 3)
            assert(Exercises.max1(Seq(1)) == 1)
            assert(Exercises.max1(Seq(-1, -2, -3)) == -1)
            assert(intercept[Exception]{ Exercises.max1(Seq()) }.getClass.getSimpleName
              == "IllegalArgumentException")
            assert(intercept[Exception]{ Exercises.max1(Seq.empty) }.getClass.getSimpleName
              == "IllegalArgumentException")
        }
        'max2 - {
            assert(Exercises.max2(Seq(1, 2, 3)) == Seq(3))
            assert(Exercises.max2(Seq(1)) == Seq(1))
            assert(Exercises.max2(Seq(-1, -2, -3)) == Seq(-1))
            assert(Exercises.max2(Seq.empty) == Seq.empty)
            assert(Exercises.max2(Seq()) == Seq.empty)
        }
        'max3 - {
            assert(Exercises.max3(Seq(1, 2, 3)) == Some(3))
            assert(Exercises.max3(Seq(1)) == Some(1))
            assert(Exercises.max3(Seq(-1, -2, -3)) == Some(-1))
            assert(Exercises.max3(Seq.empty) == None)
            assert(Exercises.max3(Seq()) ==  None)
        }
        'sum1 - {
            assert(Exercises.sum1(2, 1) == 3)
            assert(Exercises.sum1(1, -1) == 0)
            assert(Exercises.sum1(0, 0) == 0)
        }
        'sum2 - {
            assert(Exercises.sum2(2, 1) == 3)
            assert(Exercises.sum2(1, -1) == 0)
            assert(Exercises.sum2(0, 0) == 0)
        }
        'sum3 - {
            assert(Exercises.sum3(2, 1) == 3)
            assert(Exercises.sum3(1, -1) == 0)
            assert(Exercises.sum3(0, 0) == 0)
        }
    }
}
