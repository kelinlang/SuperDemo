package com.kelinlang.viewapp.opengl;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


/**
 * @author dengjun
 *         实现的主要功能。
 * @CreateDate 2017/7/6 0006
 */

public class AirHockeyRenderer implements GLSurfaceView.Renderer {
    private static final int POSITION_COMPONENT_COUNT = 2;
    private static final int BYTES_PER_FLOAT = 4;
    private  FloatBuffer vertexData;


    private float[] tableVertices = {
            0f,0f,
            0f,14f,
            9f,14f,
            9f,0f,
    };

    private float[] tableVerticesWithTriagles = {
            //triangle 1
            0f,0f,
            9f,14f,
            0f,14f,

            //triangle 2
            0f,0f,
            9f,0f,
            9f,14f,

            //line1
            0f,7f,
            9f,7f,

            //line2
            4.5f,2f,
            4.5f,12f,
    };


    public AirHockeyRenderer() {
        vertexData = ByteBuffer
                .allocateDirect(tableVerticesWithTriagles.length*BYTES_PER_FLOAT)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        vertexData.put(tableVerticesWithTriagles);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES20.glClearColor(1.0f,0.0f,0.0f,0.0f);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES20.glViewport(0,0,width,height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
    }
}
