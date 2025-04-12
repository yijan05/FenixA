import cv2
import mediapipe as mp

# Inicializar módulos de MediaPipe
mp_face_mesh = mp.solutions.face_mesh
mp_drawing = mp.solutions.drawing_utils

# Capturar video desde la cámara
cap = cv2.VideoCapture(0, cv2.CAP_DSHOW)

with mp_face_mesh.FaceMesh(
    static_image_mode=False,
    max_num_faces=2,
    min_detection_confidence=0.5) as face_mesh:

    while True:
        ret, frame = cap.read()
        if not ret:
            break
        
        # Voltear imagen y convertir a RGB
        frame = cv2.flip(frame, 1)
        frame_rgb = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
        results = face_mesh.process(frame_rgb)

        # Dibujar malla facial si se detecta un rostro
        if results.multi_face_landmarks:
            for face_landmarks in results.multi_face_landmarks:
                mp_drawing.draw_landmarks(
                    frame, face_landmarks,
                    mp_face_mesh.FACEMESH_TESSELATION,  # Reemplazo de FACE_CONNECTIONS
                    mp_drawing.DrawingSpec(color=(0, 255, 255), thickness=1, circle_radius=1),
                    mp_drawing.DrawingSpec(color=(255, 0, 255), thickness=1)
                )

        # Mostrar el resultado
        cv2.imshow("Frame", frame)
        k = cv2.waitKey(1) & 0xFF
        if k == ord('q'):  # Tecla 'q' para salir
            break

cap.release()
cv2.destroyAllWindows()
