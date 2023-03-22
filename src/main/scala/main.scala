// VQS : Quantum Computing Simulation
// Gildas Ménier
// 2020
// gildas.menier@univ-ubs.fr

import Vqs._
import Vqs.operators._

object main {
      // lancer le programme avec la commande "sbt compile" puis "sbt run" dans le dossier VisuelQuantumSimulator
      def main(args: Array[String]): Unit = {
            QReg.setDefaultUseColor()
            QReg.setDefaultUseASCII()

            println("Super Dense Coding")

            println("vcode = 0 : ")
            superDense(0)

            println("vcode = 1 : ")
            superDense(1)

            println("vcode = 2 : ")
            superDense(2)

            println("vcode = 3 : ")
            superDense(3)
      }

      // Permet de simuler la transmission de la valeur vcode
      def superDense(vcode : Int) { 
            val rr : QReg = QReg(2);

            rr - $(0, "Bob") - $(1, "Alice")

            rr - H(0)
            rr - C(Not(1), 0)

            vcode match {
                  case 1 => rr - X(1)
                  case 2 => rr - Z(1)
                  case 3 => rr - Y(1)
                  case _ => ()
            }

            rr - Label("Alice -> Bob")

            rr - C(Not(0), 1)
            rr - H(1)

            rr - <(0)
            rr - <(1)

            println(rr.render)

            println("Bob measure : " + rr.?(0))
            println("Alice measure : " + rr.?(1))

            rr.end
      }
}