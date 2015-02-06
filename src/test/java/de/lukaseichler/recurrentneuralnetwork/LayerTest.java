package de.lukaseichler.recurrentneuralnetwork;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author leichler
 */
public class LayerTest {

    @Test
    public void simpleInput() throws Exception {
        Layer layer = new Layer(1);
        assertThat(layer.calculate(2, 3)).containsOnly(5.0);
    }

    @Test
    public void multipleNodes() throws Exception {
        Layer layer = new Layer(2);
        assertThat(layer.calculate(2, 3)).containsOnly(5.0, 5.0);
    }

    @Test
    public void multipleNodesWithActivationFunction() throws Exception {
        Layer layer = new Layer(2, new LogActivation());
        double value = new LogActivation().apply(5);
        assertThat(layer.calculate(2, 3)).containsOnly(value, value);

    }
}
