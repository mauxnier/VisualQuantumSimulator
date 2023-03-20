// VQS : Quantum Computing Simulation
// Gildas Ménier
// 2020
// gildas.menier@univ-ubs.fr

import Vqs._
import Vqs.operators._

// lancer le programme avec la commande "sbt compile" puis "sbt run" dans le dossier VisuelQuantumSimulator
object main {
   // Permet de simuler la transmission de la valeur vcode
   def superDense(vcode : Int) {
      println("Alice (#1) and Bob (#2) share an EPR pair");
      println("Alice encode the value 0");
      println("Alice send its QBit to Bob");
      println("Bob decode the QBit from Alice");
      println("Bob perform a measurement on the QBit");
      println("Bob read 0");

      rr - $(0, "Bob") - $(1, "Alice")
      rr - Label("Alice -> Bob")
      rr - C(Not(0), 1)
   }
   
   def main(args : Array[String]): Unit = {
      println("Run");
      superDense(0);
   }
}