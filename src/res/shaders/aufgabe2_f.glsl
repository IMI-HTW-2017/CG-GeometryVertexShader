#version 330

in vec3 vertexColor;
in vec2 vertexCoord;

out vec3 pixelColor;

void drawRect(vec2 position, vec2 size) {
    if (vertexCoord.x >= position.x && vertexCoord.x <= position.x + size.x &&
        vertexCoord.y >= position.y && vertexCoord.y <= position.y + size.y) {
        pixelColor = vec3(1.0, 1.0, 1.0);
    }
}

void drawCircle(vec2 position, float radius) {
    float distance = distance(position, vertexCoord);
    if (distance <= radius) {
        pixelColor = vec3(1.0, 1.0, 1.0);
    }
}

void main() {
    pixelColor = vertexColor;
    //drawCircle(vec2(0, -0.3), 0.1);
}