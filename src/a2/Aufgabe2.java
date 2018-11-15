package a2;

import lenz.opengl.AbstractOpenGLBase;
import lenz.opengl.ShaderProgram;

import static org.lwjgl.opengl.GL30.*;

public class Aufgabe2 extends AbstractOpenGLBase {

    private ShaderProgram shaderProgram;
    private float angle = 0;

	public static void main(String[] args) {
		new Aufgabe2().start("CG Aufgabe 2", 700, 700);
	}

	@Override
	protected void init() {
		// folgende Zeile läd automatisch "aufgabe2.v" (vertex) und "aufgabe2.f" (fragment)
        shaderProgram = new ShaderProgram("aufgabe2");
		glUseProgram(shaderProgram.getId());

		// Koordinaten, VAO, VBO, ... hier anlegen und im Grafikspeicher ablegen
		int vaoID = glGenVertexArrays();
		glBindVertexArray(vaoID);

		int vboID = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, vboID);

		/*float[] vertices = new float[] {
                -0.5F, -0.5F,
                0.5F, -0.5F,
                0, 0.5F
        };*/

        float[] vertices = new float[] {
                -0.5F, -0.5F,
                0.5F, -0.5F,
                -0.5F, 0.5F,

                -0.5F, 0.5F,
                0.5F, -0.5F,
                0.5F, 0.5F
        };

        //Cube
        /*float[] vertices = new float[] {
                //vorne
                -0.5F, -0.5F, -0.5F,
                0.5F, -0.5F, -0.5F,
                -0.5F, 0.5F, -0.5F,

                -0.5F, 0.5F, -0.5F,
                0.5F, -0.5F, -0.5F,
                0.5F, 0.5F, -0.5F,

                //hinten
                -0.5F, -0.5F, -1.5F,
                -0.5F, 0.5F, -1.5F,
                0.5F, -0.5F, -1.5F,

                -0.5F, 0.5F, -1.5F,
                0.5F, 0.5F, -1.5F,
                0.5F, -0.5F, -1.5F,

                //unten
                -0.5F, -0.5F, -0.5F,
                0.5F, -0.5F, -0.5F,
                0.5F, -0.5F, -1.5F,

                -0.5F, -0.5F, -0.5F,
                0.5F, -0.5F, -1.5F,
                -0.5F, -0.5F, -1.5F,

                //oben
                -0.5F, 0.5F, -0.5F,
                0.5F, 0.5F, -0.5F,
                0.5F, 0.5F, -1.5F,

                -0.5F, 0.5F, -0.5F,
                0.5F, 0.5F, -1.5F,
                -0.5F, 0.5F, -1.5F,

                //links
                -0.5F, 0.5F, -0.5F,
                -0.5F, 0.5F, -1.5F,
                -0.5F, -0.5F, -0.5F,

                -0.5F, -0.5F, -0.5F,
                -0.5F, 0.5F, -1.5F,
                -0.5F, -0.5F, -1.5F,

                //rechts
                0.5F, 0.5F, -0.5F,
                0.5F, 0.5F, -1.5F,
                0.5F, -0.5F, -0.5F,

                0.5F, -0.5F, -0.5F,
                0.5F, 0.5F, -1.5F,
                0.5F, -0.5F, -1.5F
        };*/

		glBufferData(GL_ARRAY_BUFFER, vertices, GL_STATIC_DRAW);

        glVertexAttribPointer(0, 2, GL_FLOAT, false, 0, 0);
        glEnableVertexAttribArray(0);

	}

	@Override
	public void update() {
	    angle = (angle + 1) % 360;

	    int uniformAngleID = glGetUniformLocation(shaderProgram.getId(), "angle");
	    glUniform1f(uniformAngleID, angle);
	}

	@Override
	protected void render() {
		glClear(GL_COLOR_BUFFER_BIT); // Zeichenfläche leeren

        /*for (int i = 0; i < vertices.length; i += 2) {
            vertices[i] = (float)(vertices[i] * Math.cos(0.01) + vertices[i + 1] * -Math.sin(0.01));
            vertices[i + 1] = (float)(vertices[i] * Math.sin(0.01) + vertices[i + 1] * Math.cos(0.01));
        }

        glBufferData(GL_ARRAY_BUFFER, vertices, GL_STATIC_DRAW);*/

		glDrawArrays(GL_TRIANGLES, 0, 6);
	}

	@Override
	public void destroy() {
	}
}
