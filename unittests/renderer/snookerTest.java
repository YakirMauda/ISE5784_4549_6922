package renderer;

import static java.awt.Color.*;

import org.junit.jupiter.api.Test;
import geometries.*;
import lighting.*;
import primitives.*;
import scene.Scene;

/**
 * Test rendering a basic image
 */
public class snookerTest {
    /**
     * Scene of the tests
     */
    private final Scene scene = new Scene("Test scene");
    /**
     * Camera builder of the tests
     */
    private final Camera.Builder camera = Camera.getBuilder()
            .setRayTracer(new SimpleRayTracer(scene))
            .setLocation(new Point(200, 200, 100))
            .setDirection(new Point(0, 0, 0), new Vector(-1, -30, 180).normalize())
            .setVpDistance(500)
            .setVpSize(200, 200)
            .setNumSamples(9)
            .setMultithreading(3); //
            //.setDebugPrint(0.1); // progress update intervak in %

    /**
     * Produce a scene with basic 3D model and render it into a png image with a
     * grid
     */
    @Test
    public void snookerrrTest() {

        Material material1 = new Material().setKd(0.0).setKs(0.5).setShininess(500).setkT(0.0).setkR(0.0);
        Color color1 = new Color(0, 0, 0);

        Material material2 = new Material().setKd(0.06895158137194812).setKs(0.5).setShininess(500).setkT(0.0).setkR(0.0);
        Color color2 = new Color(0, 51, 0);

        Material material3 = new Material().setKd(0.033753237687051296).setKs(0.5).setShininess(500).setkT(0.0).setkR(0.0);
        Color color3 = new Color(22, 3, 0);

        scene.geometries.add(
                new Triangle(new Point(-41.679039001464844, -24.331174850463867, 1.0635494618327357e-06),
                        new Point(-41.17927169799805, -24.830944061279297, -15.100517272949219),
                        new Point(-41.17927169799805, -24.830944061279297, 1.0853950698219705e-06)).
                        setMaterial(new Material().setKd(0.0).setKs(0.5).setShininess(500).setkT(0.0).setkR(0.0))
                        .setEmission(new Color(0, 0, 0)),

                new Triangle(new Point(-41.679039001464844, 0.0, 0.0),
                        new Point(-41.679039001464844, -24.331174850463867, -15.100517272949219),
                        new Point(-41.679039001464844, -24.331174850463867, 1.0635494618327357e-06)).
                        setMaterial(new Material().setKd(0.0).setKs(0.5).setShininess(500).setkT(0.0).setkR(0.0))
                        .setEmission(new Color(0, 0, 0)),

                new Triangle(
                        new Point(-41.679039001464844, 24.331174850463867, -1.0635494618327357e-06),
                        new Point(-41.679039001464844, -6.600646429433255e-07, -15.100518226623535),
                        new Point(-41.679039001464844, 0.0, 0.0))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(-41.17927169799805, 24.830944061279297, -1.0853950698219705e-06),
                        new Point(-41.679039001464844, 24.331174850463867, -15.100519180297852),
                        new Point(-41.679039001464844, 24.331174850463867, -1.0635494618327357e-06))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(-40.679500579833984, 25.330713272094727, -1.1072406778112054e-06),
                        new Point(-41.17927169799805, 24.830944061279297, -15.100519180297852),
                        new Point(-41.17927169799805, 24.830944061279297, -1.0853950698219705e-06))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(0.0, 25.330713272094727, -1.1072406778112054e-06),
                        new Point(-40.679500579833984, 25.330713272094727, -15.100519180297852),
                        new Point(-40.679500579833984, 25.330713272094727, -1.1072406778112054e-06))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(40.679500579833984, 25.330713272094727, -1.1072406778112054e-06),
                        new Point(0.0, 25.330713272094727, -15.100519180297852),
                        new Point(0.0, 25.330713272094727, -1.1072406778112054e-06))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(41.17927169799805, 24.830944061279297, -1.0853950698219705e-06),
                        new Point(40.679500579833984, 25.330713272094727, -15.100519180297852),
                        new Point(40.679500579833984, 25.330713272094727, -1.1072406778112054e-06))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(41.679039001464844, 24.331174850463867, -1.0635494618327357e-06),
                        new Point(41.17927169799805, 24.830944061279297, -15.100519180297852),
                        new Point(41.17927169799805, 24.830944061279297, -1.0853950698219705e-06))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(41.679039001464844, 24.331174850463867, -1.0635494618327357e-06),
                        new Point(41.679039001464844, -6.600646429433255e-07, -15.100518226623535),
                        new Point(41.679039001464844, 24.331174850463867, -15.100519180297852))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(41.679039001464844, 0.0, 0.0),
                        new Point(41.679039001464844, -24.331174850463867, -15.100517272949219),
                        new Point(41.679039001464844, -6.600646429433255e-07, -15.100518226623535))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(41.17927169799805, -24.830944061279297, 1.0853950698219705e-06),
                        new Point(41.679039001464844, -24.331174850463867, -15.100517272949219),
                        new Point(41.679039001464844, -24.331174850463867, 1.0635494618327357e-06))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(40.679500579833984, -25.330713272094727, 1.1072406778112054e-06),
                        new Point(41.17927169799805, -24.830944061279297, -15.100517272949219),
                        new Point(41.17927169799805, -24.830944061279297, 1.0853950698219705e-06))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(0.0, -25.330713272094727, 1.1072406778112054e-06),
                        new Point(40.679500579833984, -25.330713272094727, -15.100517272949219),
                        new Point(40.679500579833984, -25.330713272094727, 1.1072406778112054e-06))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(-40.679500579833984, -25.330713272094727, 1.1072406778112054e-06),
                        new Point(0.0, -25.330713272094727, -15.100517272949219),
                        new Point(0.0, -25.330713272094727, 1.1072406778112054e-06))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(-41.17927169799805, -24.830944061279297, 1.0853950698219705e-06),
                        new Point(-40.679500579833984, -25.330713272094727, -15.100517272949219),
                        new Point(-40.679500579833984, -25.330713272094727, 1.1072406778112054e-06))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(-41.679039001464844, -24.331174850463867, 1.0635494618327357e-06),
                        new Point(-41.679039001464844, -24.331174850463867, -15.100517272949219),
                        new Point(-41.17927169799805, -24.830944061279297, -15.100517272949219))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(-41.679039001464844, 0.0, 0.0),
                        new Point(-41.679039001464844, -6.600646429433255e-07, -15.100518226623535),
                        new Point(-41.679039001464844, -24.331174850463867, -15.100517272949219))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(-41.679039001464844, 24.331174850463867, -1.0635494618327357e-06),
                        new Point(-41.679039001464844, 24.331174850463867, -15.100519180297852),
                        new Point(-41.679039001464844, -6.600646429433255e-07, -15.100518226623535))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(-41.17927169799805, 24.830944061279297, -1.0853950698219705e-06),
                        new Point(-41.17927169799805, 24.830944061279297, -15.100519180297852),
                        new Point(-41.679039001464844, 24.331174850463867, -15.100519180297852))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(-40.679500579833984, 25.330713272094727, -1.1072406778112054e-06),
                        new Point(-40.679500579833984, 25.330713272094727, -15.100519180297852),
                        new Point(-41.17927169799805, 24.830944061279297, -15.100519180297852))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(0.0, 25.330713272094727, -1.1072406778112054e-06),
                        new Point(0.0, 25.330713272094727, -15.100519180297852),
                        new Point(-40.679500579833984, 25.330713272094727, -15.100519180297852))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(40.679500579833984, 25.330713272094727, -1.1072406778112054e-06),
                        new Point(40.679500579833984, 25.330713272094727, -15.100519180297852),
                        new Point(0.0, 25.330713272094727, -15.100519180297852))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(41.17927169799805, 24.830944061279297, -1.0853950698219705e-06),
                        new Point(41.17927169799805, 24.830944061279297, -15.100519180297852),
                        new Point(40.679500579833984, 25.330713272094727, -15.100519180297852))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(41.679039001464844, 24.331174850463867, -1.0635494618327357e-06),
                        new Point(41.679039001464844, 24.331174850463867, -15.100519180297852),
                        new Point(41.17927169799805, 24.830944061279297, -15.100519180297852))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(41.679039001464844, 24.331174850463867, -1.0635494618327357e-06),
                        new Point(41.679039001464844, 0.0, 0.0),
                        new Point(41.679039001464844, -6.600646429433255e-07, -15.100518226623535))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(41.679039001464844, 0.0, 0.0),
                        new Point(41.679039001464844, -24.331174850463867, 1.0635494618327357e-06),
                        new Point(41.679039001464844, -24.331174850463867, -15.100517272949219))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(41.17927169799805, -24.830944061279297, 1.0853950698219705e-06),
                        new Point(41.17927169799805, -24.830944061279297, -15.100517272949219),
                        new Point(41.679039001464844, -24.331174850463867, -15.100517272949219))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(40.679500579833984, -25.330713272094727, 1.1072406778112054e-06),
                        new Point(40.679500579833984, -25.330713272094727, -15.100517272949219),
                        new Point(41.17927169799805, -24.830944061279297, -15.100517272949219))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(0.0, -25.330713272094727, 1.1072406778112054e-06),
                        new Point(0.0, -25.330713272094727, -15.100517272949219),
                        new Point(40.679500579833984, -25.330713272094727, -15.100517272949219))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(-40.679500579833984, -25.330713272094727, 1.1072406778112054e-06),
                        new Point(-40.679500579833984, -25.330713272094727, -15.100517272949219),
                        new Point(0.0, -25.330713272094727, -15.100517272949219))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(-41.17927169799805, -24.830944061279297, 1.0853950698219705e-06),
                        new Point(-41.17927169799805, -24.830944061279297, -15.100517272949219),
                        new Point(-40.679500579833984, -25.330713272094727, -15.100517272949219))
                        .setMaterial(material1)
                        .setEmission(color1),

                new Triangle(
                        new Point(-41.678348541259766, 27.742141723632812, 11.467705726623535),
                        new Point(-44.0904655456543, 25.33002281188965, 11.467705726623535),
                        new Point(-41.678348541259766, -27.742141723632812, 11.467707633972168))
                        .setMaterial(new Material().setKd(0.06895158137194812).setKs(0.5).setShininess(500).setkT(0.0).setkR(0.0))
                        .setEmission(new Color(0, 51, 0)),

                new Triangle(
                        new Point(-44.0904655456543, 25.33002281188965, 11.467705726623535),
                        new Point(-44.0904655456543, -25.33002281188965, 11.467707633972168),
                        new Point(-41.678348541259766, -27.742141723632812, 11.467707633972168))
                        .setMaterial(new Material().setKd(0.06895158137194812).setKs(0.5).setShininess(500).setkT(0.0).setkR(0.0))
                        .setEmission(new Color(0, 51, 0)),

                new Triangle(
                        new Point(-41.678348541259766, -27.742141723632812, 11.467707633972168),
                        new Point(41.678348541259766, -27.742141723632812, 11.467707633972168),
                        new Point(41.678348541259766, 27.742141723632812, 11.467705726623535))
                        .setMaterial(new Material().setKd(0.06895158137194812).setKs(0.5).setShininess(500).setkT(0.0).setkR(0.0))
                        .setEmission(new Color(0, 51, 0)),

                new Triangle(
                        new Point(41.678348541259766, -27.742141723632812, 11.467707633972168),
                        new Point(44.0904655456543, -25.33002281188965, 11.467707633972168),
                        new Point(41.678348541259766, 27.742141723632812, 11.467705726623535))
                        .setMaterial(new Material().setKd(0.06895158137194812).setKs(0.5).setShininess(500).setkT(0.0).setkR(0.0))
                        .setEmission(new Color(0, 51, 0)),

                new Triangle(
                        new Point(44.0904655456543, -25.33002281188965, 11.467707633972168),
                        new Point(44.0904655456543, 25.33002281188965, 11.467705726623535),
                        new Point(41.678348541259766, 27.742141723632812, 11.467705726623535))
                        .setMaterial(new Material().setKd(0.06895158137194812).setKs(0.5).setShininess(500).setkT(0.0).setkR(0.0))
                        .setEmission(new Color(0, 51, 0)),

                new Triangle(
                        new Point(41.678348541259766, 27.742141723632812, 11.467705726623535),
                        new Point(-41.678348541259766, 27.742141723632812, 11.467705726623535),
                        new Point(-41.678348541259766, -27.742141723632812, 11.467707633972168))
                        .setMaterial(new Material().setKd(0.06895158137194812).setKs(0.5).setShininess(500).setkT(0.0).setkR(0.0))
                        .setEmission(new Color(0, 51, 0)),

                new Triangle(
                        new Point(-42.67719268798828, -30.15357208251953, 1.3180545010982314e-06),
                        new Point(-40.679500579833984, -25.330713272094727, 1.1072406778112054e-06),
                        new Point(0.0, -25.330713272094727, 1.1072406778112054e-06))
                        .setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(42.67719268798828, -30.15357208251953, 1.3180545010982314e-06),
                        new Point(-42.67719268798828, -30.15357208251953, 13.805248260498047),
                        new Point(-42.67719268798828, -30.15357208251953, 1.3180545010982314e-06))
                        .setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(-46.501895904541016, -26.328868865966797, 13.805248260498047),
                        new Point(-42.67719268798828, -30.15357208251953, 1.3180545010982314e-06),
                        new Point(-42.67719268798828, -30.15357208251953, 13.805248260498047))
                        .setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(-46.501895904541016, -26.328868865966797, 1.1508714123920072e-06),
                        new Point(-41.679039001464844, -24.331174850463867, 1.0635494618327357e-06),
                        new Point(-41.17927169799805, -24.830944061279297, 1.0853950698219705e-06))
                        .setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(-46.501895904541016, 26.328868865966797, -1.1508714123920072e-06),
                        new Point(-41.679039001464844, 24.331174850463867, -1.0635494618327357e-06),
                        new Point(-41.679039001464844, 0.0, 0.0))
                        .setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(-42.67719268798828, 30.15357208251953, -1.3180545010982314e-06),
                        new Point(-40.679500579833984, 25.330713272094727, -1.1072406778112054e-06),
                        new Point(-41.17927169799805, 24.830944061279297, -1.0853950698219705e-06))
                        .setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(42.67719268798828, 30.15357208251953, -1.3180545010982314e-06),
                        new Point(40.679500579833984, 25.330713272094727, -1.1072406778112054e-06),
                        new Point(0.0, 25.330713272094727, -1.1072406778112054e-06))
                        .setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(46.501895904541016, 26.328868865966797, -1.1508714123920072e-06),
                        new Point(41.679039001464844, 24.331174850463867, -1.0635494618327357e-06),
                        new Point(41.17927169799805, 24.830944061279297, -1.0853950698219705e-06))
                        .setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(46.501895904541016, -26.328868865966797, 1.1508714123920072e-06),
                        new Point(41.679039001464844, -24.331174850463867, 1.0635494618327357e-06),
                        new Point(41.17927169799805, -24.830944061279297, 1.0853950698219705e-06))
                        .setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(42.67719268798828, -30.15357208251953, 1.3180545010982314e-06),
                        new Point(40.679500579833984, -25.330713272094727, 1.1072406778112054e-06),
                        new Point(41.17927169799805, -24.830944061279297, 1.0853950698219705e-06))
                        .setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(46.501895904541016, -26.328868865966797, 1.1508714123920072e-06),
                        new Point(46.501895904541016, 26.328868865966797, 13.805246353149414),
                        new Point(46.501895904541016, -26.328868865966797, 13.805248260498047)
                ).setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(46.501895904541016, -26.328868865966797, 1.1508714123920072e-06),
                        new Point(42.67719268798828, -30.15357208251953, 13.805248260498047),
                        new Point(42.67719268798828, -30.15357208251953, 1.3180545010982314e-06)
                ).setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(46.501895904541016, 26.328868865966797, 13.805246353149414),
                        new Point(44.0904655456543, -25.33002281188965, 13.805248260498047),
                        new Point(46.501895904541016, -26.328868865966797, 13.805248260498047)
                ).setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(46.501895904541016, -26.328868865966797, 13.805248260498047),
                        new Point(41.678348541259766, -27.742141723632812, 13.805248260498047),
                        new Point(42.67719268798828, -30.15357208251953, 13.805248260498047)
                ).setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(44.0904655456543, -25.33002281188965, 13.805248260498047),
                        new Point(41.678348541259766, -27.742141723632812, 11.467707633972168),
                        new Point(41.678348541259766, -27.742141723632812, 13.805248260498047)
                ).setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(44.0904655456543, 25.33002281188965, 13.805246353149414),
                        new Point(44.0904655456543, -25.33002281188965, 11.467707633972168),
                        new Point(44.0904655456543, -25.33002281188965, 13.805248260498047)
                ).setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(41.678348541259766, 27.742141723632812, 13.805246353149414),
                        new Point(44.0904655456543, 25.33002281188965, 11.467705726623535),
                        new Point(44.0904655456543, 25.33002281188965, 13.805246353149414)
                ).setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(-41.678348541259766, 27.742141723632812, 13.805246353149414),
                        new Point(41.678348541259766, 27.742141723632812, 11.467705726623535),
                        new Point(41.678348541259766, 27.742141723632812, 13.805246353149414)
                ).setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(-42.67719268798828, 30.15357208251953, 13.805246353149414),
                        new Point(41.678348541259766, 27.742141723632812, 13.805246353149414),
                        new Point(42.67719268798828, 30.15357208251953, 13.805246353149414)
                ).setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(46.501895904541016, 26.328868865966797, 13.805246353149414),
                        new Point(41.678348541259766, 27.742141723632812, 13.805246353149414),
                        new Point(44.0904655456543, 25.33002281188965, 13.805246353149414)
                ).setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(-46.501895904541016, 26.328868865966797, 13.805248260498047),
                        new Point(-41.678348541259766, 27.742141723632812, 13.805246353149414),
                        new Point(-42.67719268798828, 30.15357208251953, 13.805246353149414)
                ).setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(-44.0904655456543, 25.33002281188965, 13.805246353149414),
                        new Point(-41.678348541259766, 27.742141723632812, 11.467705726623535),
                        new Point(-41.678348541259766, 27.742141723632812, 13.805246353149414)
                ).setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(-46.501895904541016, -26.328868865966797, 13.805248260498047),
                        new Point(-44.0904655456543, 25.33002281188965, 13.805246353149414),
                        new Point(-46.501895904541016, 26.328868865966797, 13.805246353149414)
                ).setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(-44.0904655456543, -25.33002281188965, 13.805248260498047),
                        new Point(-44.0904655456543, 25.33002281188965, 11.467705726623535),
                        new Point(-44.0904655456543, 25.33002281188965, 13.805246353149414)
                ).setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(-41.678348541259766, -27.742141723632812, 13.805248260498047),
                        new Point(-44.0904655456543, -25.33002281188965, 11.467707633972168),
                        new Point(-44.0904655456543, -25.33002281188965, 13.805248260498047)
                ).setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(41.678348541259766, -27.742141723632812, 13.805248260498047),
                        new Point(-41.678348541259766, -27.742141723632812, 11.467707633972168),
                        new Point(-41.678348541259766, -27.742141723632812, 13.805248260498047)
                ).setMaterial(material3)
                        .setEmission(color3),

                new Triangle(
                        new Point(42.67719268798828, -30.15357208251953, 13.805248260498047),
                        new Point(-41.678348541259766, -27.742141723632812, 13.805248260498047),
                        new Point(-42.67719268798828, -30.15357208251953, 13.805248260498047)
                ).setMaterial(material3)
                        .setEmission(color3),

                new Triangle(new Point(-46.501895904541016, -26.328868865966797, 13.805248260498047),
                        new Point(-41.678348541259766, -27.742141723632812, 13.805248260498047),
                        new Point(-44.0904655456543, -25.33002281188965, 13.805248260498047))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(-46.501895904541016, -26.328868865966797, 1.1508714123920072e-06),
                        new Point(-46.501895904541016, 26.328868865966797, 13.805246353149414),
                        new Point(-46.501895904541016, 26.328868865966797, -1.1508714123920072e-06))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(-46.501895904541016, 26.328868865966797, -1.1508714123920072e-06),
                        new Point(-42.67719268798828, 30.15357208251953, 13.805246353149414),
                        new Point(-42.67719268798828, 30.15357208251953, -1.3180545010982314e-06))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(-42.67719268798828, 30.15357208251953, -1.3180545010982314e-06),
                        new Point(42.67719268798828, 30.15357208251953, 13.805246353149414),
                        new Point(42.67719268798828, 30.15357208251953, -1.3180545010982314e-06))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(42.67719268798828, 30.15357208251953, -1.3180545010982314e-06),
                        new Point(46.501895904541016, 26.328868865966797, 13.805246353149414),
                        new Point(46.501895904541016, 26.328868865966797, -1.1508714123920072e-06))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(40.679500579833984, -25.330713272094727, 1.1072406778112054e-06),
                        new Point(42.67719268798828, -30.15357208251953, 1.3180545010982314e-06),
                        new Point(0.0, -25.330713272094727, 1.1072406778112054e-06))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(42.67719268798828, -30.15357208251953, 1.3180545010982314e-06),
                        new Point(-42.67719268798828, -30.15357208251953, 1.3180545010982314e-06),
                        new Point(0.0, -25.330713272094727, 1.1072406778112054e-06))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(42.67719268798828, -30.15357208251953, 1.3180545010982314e-06),
                        new Point(42.67719268798828, -30.15357208251953, 13.805248260498047),
                        new Point(-42.67719268798828, -30.15357208251953, 13.805248260498047))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(-46.501895904541016, -26.328868865966797, 13.805248260498047),
                        new Point(-46.501895904541016, -26.328868865966797, 1.1508714123920072e-06),
                        new Point(-42.67719268798828, -30.15357208251953, 1.3180545010982314e-06))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(-40.679500579833984, -25.330713272094727, 1.1072406778112054e-06),
                        new Point(-42.67719268798828, -30.15357208251953, 1.3180545010982314e-06),
                        new Point(-41.17927169799805, -24.830944061279297, 1.0853950698219705e-06))
                        .setMaterial(material3)
                        .setEmission(color3),

                new Triangle(new Point(-42.67719268798828, -30.15357208251953, 1.3180545010982314e-06),
                        new Point(-46.501895904541016, -26.328868865966797, 1.1508714123920072e-06),
                        new Point(-41.17927169799805, -24.830944061279297, 1.0853950698219705e-06))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(-41.679039001464844, -24.331174850463867, 1.0635494618327357e-06),
                        new Point(-46.501895904541016, -26.328868865966797, 1.1508714123920072e-06),
                        new Point(-41.679039001464844, 0.0, 0.0))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(-46.501895904541016, -26.328868865966797, 1.1508714123920072e-06),
                        new Point(-46.501895904541016, 26.328868865966797, -1.1508714123920072e-06),
                        new Point(-41.679039001464844, 0.0, 0.0))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(-41.679039001464844, 24.331174850463867, -1.0635494618327357e-06),
                        new Point(-46.501895904541016, 26.328868865966797, -1.1508714123920072e-06),
                        new Point(-41.17927169799805, 24.830944061279297, -1.0853950698219705e-06))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(-46.501895904541016, 26.328868865966797, -1.1508714123920072e-06),
                        new Point(-42.67719268798828, 30.15357208251953, -1.3180545010982314e-06),
                        new Point(-41.17927169799805, 24.830944061279297, -1.0853950698219705e-06))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(-40.679500579833984, 25.330713272094727, -1.1072406778112054e-06),
                        new Point(-42.67719268798828, 30.15357208251953, -1.3180545010982314e-06),
                        new Point(0.0, 25.330713272094727, -1.1072406778112054e-06))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(-42.67719268798828, 30.15357208251953, -1.3180545010982314e-06),
                        new Point(42.67719268798828, 30.15357208251953, -1.3180545010982314e-06),
                        new Point(0.0, 25.330713272094727, -1.1072406778112054e-06))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(40.679500579833984, 25.330713272094727, -1.1072406778112054e-06),
                        new Point(42.67719268798828, 30.15357208251953, -1.3180545010982314e-06),
                        new Point(41.17927169799805, 24.830944061279297, -1.0853950698219705e-06))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(42.67719268798828, 30.15357208251953, -1.3180545010982314e-06),
                        new Point(46.501895904541016, 26.328868865966797, -1.1508714123920072e-06),
                        new Point(41.17927169799805, 24.830944061279297, -1.0853950698219705e-06))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(41.679039001464844, 24.331174850463867, -1.0635494618327357e-06),
                        new Point(46.501895904541016, 26.328868865966797, -1.1508714123920072e-06),
                        new Point(41.679039001464844, 0.0, 0.0))
                        .setMaterial(material3)
                        .setEmission(color3),

                new Triangle(new Point(46.501895904541016, 26.328868865966797, -1.1508714123920072e-06),
                        new Point(46.501895904541016, -26.328868865966797, 1.1508714123920072e-06),
                        new Point(41.679039001464844, 0.0, 0.0))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(41.679039001464844, -24.331174850463867, 1.0635494618327357e-06),
                        new Point(46.501895904541016, -26.328868865966797, 1.1508714123920072e-06),
                        new Point(41.17927169799805, -24.830944061279297, 1.0853950698219705e-06))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(46.501895904541016, -26.328868865966797, 1.1508714123920072e-06),
                        new Point(42.67719268798828, -30.15357208251953, 1.3180545010982314e-06),
                        new Point(41.17927169799805, -24.830944061279297, 1.0853950698219705e-06))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(46.501895904541016, -26.328868865966797, 1.1508714123920072e-06),
                        new Point(46.501895904541016, 26.328868865966797, -1.1508714123920072e-06),
                        new Point(46.501895904541016, 26.328868865966797, 13.805246353149414))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(46.501895904541016, -26.328868865966797, 1.1508714123920072e-06),
                        new Point(46.501895904541016, -26.328868865966797, 13.805248260498047),
                        new Point(42.67719268798828, -30.15357208251953, 13.805248260498047))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(46.501895904541016, 26.328868865966797, 13.805246353149414),
                        new Point(44.0904655456543, 25.33002281188965, 13.805246353149414),
                        new Point(44.0904655456543, -25.33002281188965, 13.805248260498047))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(46.501895904541016, -26.328868865966797, 13.805248260498047),
                        new Point(44.0904655456543, -25.33002281188965, 13.805248260498047),
                        new Point(41.678348541259766, -27.742141723632812, 13.805248260498047))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(44.0904655456543, -25.33002281188965, 13.805248260498047),
                        new Point(44.0904655456543, -25.33002281188965, 11.467707633972168),
                        new Point(41.678348541259766, -27.742141723632812, 11.467707633972168))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(44.0904655456543, 25.33002281188965, 13.805246353149414),
                        new Point(44.0904655456543, 25.33002281188965, 11.467705726623535),
                        new Point(44.0904655456543, -25.33002281188965, 11.467707633972168))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(41.678348541259766, 27.742141723632812, 13.805246353149414),
                        new Point(41.678348541259766, 27.742141723632812, 11.467705726623535),
                        new Point(44.0904655456543, 25.33002281188965, 11.467705726623535))
                        .setMaterial(material3)
                        .setEmission(color3),


                new Triangle(new Point(-41.678348541259766, 27.742141723632812, 13.805246353149414),
                        new Point(-41.678348541259766, 27.742141723632812, 11.467705726623535),
                        new Point(41.678348541259766, 27.742141723632812, 11.467705726623535))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(-42.67719268798828, 30.15357208251953, 13.805246353149414),
                        new Point(-41.678348541259766, 27.742141723632812, 13.805246353149414),
                        new Point(41.678348541259766, 27.742141723632812, 13.805246353149414))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(46.501895904541016, 26.328868865966797, 13.805246353149414),
                        new Point(42.67719268798828, 30.15357208251953, 13.805246353149414),
                        new Point(41.678348541259766, 27.742141723632812, 13.805246353149414))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(-46.501895904541016, 26.328868865966797, 13.805246353149414),
                        new Point(-44.0904655456543, 25.33002281188965, 13.805246353149414),
                        new Point(-41.678348541259766, 27.742141723632812, 13.805246353149414))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(-44.0904655456543, 25.33002281188965, 13.805246353149414),
                        new Point(-44.0904655456543, 25.33002281188965, 11.467705726623535),
                        new Point(-41.678348541259766, 27.742141723632812, 11.467705726623535))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(-46.501895904541016, -26.328868865966797, 13.805248260498047),
                        new Point(-44.0904655456543, -25.33002281188965, 13.805248260498047),
                        new Point(-44.0904655456543, 25.33002281188965, 13.805246353149414))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(-44.0904655456543, -25.33002281188965, 13.805248260498047),
                        new Point(-44.0904655456543, -25.33002281188965, 11.467707633972168),
                        new Point(-44.0904655456543, 25.33002281188965, 11.467705726623535))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(-41.678348541259766, -27.742141723632812, 13.805248260498047),
                        new Point(-41.678348541259766, -27.742141723632812, 11.467707633972168),
                        new Point(-44.0904655456543, -25.33002281188965, 11.467707633972168))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(41.678348541259766, -27.742141723632812, 13.805248260498047),
                        new Point(41.678348541259766, -27.742141723632812, 11.467707633972168),
                        new Point(-41.678348541259766, -27.742141723632812, 11.467707633972168))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(42.67719268798828, -30.15357208251953, 13.805248260498047),
                        new Point(41.678348541259766, -27.742141723632812, 13.805248260498047),
                        new Point(-41.678348541259766, -27.742141723632812, 13.805248260498047))
                        .setMaterial(material3)
                        .setEmission(color3),

                new Triangle(new Point(-46.501895904541016, -26.328868865966797, 13.805248260498047),
                        new Point(-42.67719268798828, -30.15357208251953, 13.805248260498047),
                        new Point(-41.678348541259766, -27.742141723632812, 13.805248260498047))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(-46.501895904541016, -26.328868865966797, 1.1508714123920072e-06),
                        new Point(-46.501895904541016, -26.328868865966797, 13.805248260498047),
                        new Point(-46.501895904541016, 26.328868865966797, 13.805246353149414))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(-46.501895904541016, 26.328868865966797, -1.1508714123920072e-06),
                        new Point(-46.501895904541016, 26.328868865966797, 13.805246353149414),
                        new Point(-42.67719268798828, 30.15357208251953, 13.805246353149414))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(-42.67719268798828, 30.15357208251953, -1.3180545010982314e-06),
                        new Point(-42.67719268798828, 30.15357208251953, 13.805246353149414),
                        new Point(42.67719268798828, 30.15357208251953, 13.805246353149414))
                        .setMaterial(material3)
                        .setEmission(color3),
                new Triangle(new Point(42.67719268798828, 30.15357208251953, -1.3180545010982314e-06),
                        new Point(42.67719268798828, 30.15357208251953, 13.805246353149414),
                        new Point(46.501895904541016, 26.328868865966797, 13.805246353149414))
                        .setMaterial(material3)
                        .setEmission(color3),

                new Sphere(new Point(-28.216283798217773 + 35, -10.6532992720603943, 14.5 + 4), 3)              // The white ball
                        .setMaterial(new Material().setKd(0.4).setKs(0.8).setShininess(30).setkR(0.6))
                        .setEmission(new Color(100, 100, 100)), // White

                new Sphere(new Point(15.436763763427734, -0.1187283918261528, 14.5), 3)              // The red ball
                        .setMaterial(new Material().setKd(0.0).setKs(0.0).setShininess(0).setkT(0.0).setkR(0.0))
                        .setEmission(new Color(255, 0, 0)), // Red

                new Sphere(new Point(17.8597354888916, 1.298505425453186, 14.5), 3)              // The yellow ball
                        .setMaterial(new Material().setKd(0.0).setKs(0.0).setShininess(0).setkT(0.0).setkR(0.0))
                        .setEmission(new Color(255, 255, 0)), // Yellow

                new Sphere(new Point(17.900432586669922, -1.4634398221969604, 14.5), 3)              // The blue ball
                        .setMaterial(new Material().setKd(0.0).setKs(0.0).setShininess(0).setkT(0.0).setkR(0.0))
                        .setEmission(new Color(0, 0, 255)), // Blue

                new Sphere(new Point(20.222408294677734, -0.1248767152428627, 14.5), 3)              // The green ball
                        .setMaterial(new Material().setKd(0.0).setKs(0.0).setShininess(0).setkT(0.0).setkR(0.0))
                        .setEmission(new Color(0, 255, 0)), // Green

                new Sphere(new Point(20.40655517578125, 2.4198384284973145, 14.5), 3)              // The orange ball
                        .setMaterial(new Material().setKd(0.0).setKs(0.0).setShininess(0).setkT(0.0).setkR(0.0))
                        .setEmission(new Color(255, 165, 0)), // Orange

                new Sphere(new Point(20.3784236907959, -2.981062650680542, 14.5), 3)              // The purple ball
                        .setMaterial(new Material().setKd(0.0).setKs(0.0).setShininess(0).setkT(0.0).setkR(0.0))
                        .setEmission(new Color(128, 0, 128)), // Purple

                new Sphere(new Point(23.13673973083496, -4.2078351974487305, 14.5), 3)              // The brown ball
                        .setMaterial(new Material().setKd(0.0).setKs(0.0).setShininess(0).setkT(0.0).setkR(0.0))
                        .setEmission(new Color(165, 42, 42)), // Brown

                new Sphere(new Point(22.750577926635742, -1.4115896224975586, 14.5), 3)              // The pink ball
                        .setMaterial(new Material().setKd(0.0).setKs(0.0).setShininess(0).setkT(0.0).setkR(0.0))
                        .setEmission(new Color(255, 105, 180)), // Pink

                new Sphere(new Point(22.770854949951172, 1.1483960151672363, 14.5), 3)              // The black ball
                        .setMaterial(new Material().setKd(0.0).setKs(0.0).setShininess(0).setkT(0.0).setkR(0.0))
                        .setEmission(new Color(0, 0, 0)), // Black

                new Sphere(new Point(22.812776565551758, 3.890660285949707, 14.5), 3)              // The grey ball
                        .setMaterial(new Material().setKd(0.0).setKs(0.0).setShininess(0).setkT(0.3).setkR(0.0))
                        .setEmission(new Color(128, 128, 128)), // Grey

                new Polygon(new Point(0, 10, 32.5),     //the stick
                        new Point(15, 10, 12.5),
                        new Point(15, 10.5, 12.5),
                        new Point(0, 10.5, 32.5))
                        .setEmission(new Color(128, 64, 0))
                        .setMaterial(new Material().setKd(0.0).setKs(0.0).setShininess(0).setkT(0.7).setkR(0.0)),

                new Polygon(new Point(-60, -40, 10),    //the mirror
                        new Point(-60, -40, 40),
                        new Point(-75, -10, 40),
                        new Point(-75, -10, 10))
                        .setEmission(new Color(128, 128, 128))
                        .setMaterial(new Material().setKd(0.0).setKs(0.0).setShininess(0).setkT(0.0).setkR(1d))
        );

        // make it a BVH
        scene.geometries.makeBVH();

        // adding lights
        scene.lights.add(new PointLight(new Color(100, 200, 100), new Point(-60, 0, 60))
                .setKl(0.00001).setKq(0.000001));

        scene.lights.add(new SpotLight(new Color(100, 100, 200), new Point(50, 50, 100), new Vector(-1, -1, -1))
                .setKl(0.00001).setKq(0.000001));

        scene.lights.add(new PointLight(new Color(200, 200, 100), new Point(0, 0, 200))
                .setKl(0.00001).setKq(0.000001));

        scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0.1))
                .setBackground(new Color(100, 100, 100));

        // Render the scene
        camera.setImageWriter(new ImageWriter("snookerTest", 1000, 1000))
                .build()
                .renderImage()
                .writeToImage();

    }
}