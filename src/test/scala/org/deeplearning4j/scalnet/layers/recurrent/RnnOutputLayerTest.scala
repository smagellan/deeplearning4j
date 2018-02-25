package org.deeplearning4j.scalnet.layers.recurrent

import org.deeplearning4j.scalnet.layers.RnnOutputLayer
import org.nd4j.linalg.activations.Activation
import org.scalatest.{ Matchers, WordSpec }

class RnnOutputLayerTest extends WordSpec with Matchers {

  "A RnnOutput layer" should {

    "have an input layer of shape (10, 100)" in {
      val rnnOutputLayer = RnnOutputLayer(10, 100, Activation.SOFTMAX)
      rnnOutputLayer.inputShape shouldBe List(10, 100)
    }

    "have an ouput layer of shape (10, 100)" in {
      val rnnOutputLayer = RnnOutputLayer(10, 100, Activation.SOFTMAX)
      rnnOutputLayer.outputShape shouldBe List(100, 10)
    }

    "compile to a DL4J RnnOutputLayer" in {
      val rnnOutputLayer = RnnOutputLayer(10, 100, Activation.SOFTMAX)
      val compiledLayer = rnnOutputLayer.compile
      compiledLayer.isInstanceOf[org.deeplearning4j.nn.conf.layers.RnnOutputLayer] shouldBe true
    }

  }
}
