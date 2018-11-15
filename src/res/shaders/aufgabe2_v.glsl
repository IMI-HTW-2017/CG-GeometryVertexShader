#version 330

#define PI 3.1415926535897932384626433832795

layout(location = 0) in vec2 vertex;

uniform float angle;

out vec3 vertexColor;
out vec2 vertexCoord;

float degToRad(float degree) {
    return PI / 180 * degree;
}

vec2 rotate(vec2 vertex, float angle) {
    angle = degToRad(angle);
    mat2 rotationMatrix = mat2(cos(angle), sin(angle), -sin(angle), cos(angle));
    return rotationMatrix * vertex;
}

void main() {
    vertexCoord = vertex;

    if (vertex.x == -0.5) {
        vertexColor = vec3(0.0, 1.0, 0.0);
    } else if (vertex.x == 0.5) {
        vertexColor = vec3(0.0, 1.0, 1.0);
    } else {
        vertexColor = vec3(1.0, 1.0, 0.0);
    }

    gl_Position = vec4(rotate(vertex, angle), 0.0, 1.0);
}