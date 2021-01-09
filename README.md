# CG-GeometryVertexShader
Exercise 2 - Geometrie im Vertex-Shader

Erstellen Sie eine einfache Geometrie - z.B. ein oder mehrere Dreiecke - in Java und übertragen Sie diese an OpenGL zum Zeichnen. Implementieren Sie einen Vertrex-Shader mit den unten genannten Funktionen. Als Fragment-Shader können Sie eine feste Farbe vergeben oder eine Lösung der ersten Übung verwenden und ggf. anpassen. Verwenden Sie das zur Verfügung gestellte Rahmenwerk.

1. Übertragen Sie die Koordinaten eines Dreiecks im Achsenbereich -1..1 an die Grafikkarte als VAO/VBO-Kombination in der init-Methode und Zeichnen Sie das Dreieck in der render-Methode. Verwenden Sie anfangs möglichst einfache Shader zur Minimierung von Fehlerquellen.
2. Rotieren Sie ein Dreieck im Vertex-Shader um einen festen Winkel mithilfe einer Matrix vom Typ mat2. Vergleichen Sie die Komplexität der Lösung mit der Rotation aus der letzten Übung hinsichtlich Programmieraufwand und vermuteter Ausführungsgeschwindigkeit.
3. Übertragen Sie neben den Koordinaten zusätzliche Attribute pro Ecke, z.B. die Farbe. Reichen Sie die Daten weiter an den Fragment-Shader, um tatsächlich die Pixelfarbe zu beeinflussen.
4. Verwendet man den Fragment-Shader aus der letzten Übung, so scheint die Rotation des Dreiecks nicht für seinen Inhalt zu gelten. Verbessern lässt sich das, indem im Fragment Shader nicht die Pixelkoordinaten (gl_FragCoord), sondern die interpolierten, nicht-transformierten Eckkoordinaten aus dem Vertex Shader verwendet werden. Passen Sie Ihren Fragment Shader entsprechend an und geben Sie die unveränderten Eckkoordinaten an den Fragment Shader weiter. Achtung: Das Koordinatensystem im Fragment Shader geht dann nicht mehr von 0 bis Anzahl Pixel, sondern von -1 bis 1.

Nach Bearbeitung dieser Aufgaben sollten Sie in der Lage sein, ...

- einfache geometrische Objekte über ihre Koordinaten zu erstellen und diese zusammen mit zusätzlichen Attributen an den Shader zu leiten.
- Vertex- und Fragment-Shader zu programmieren und Daten zwischen diesen weiter zu reichen.
- Transformationen im Vertex-Shader ansatzweise zu verstehen.
