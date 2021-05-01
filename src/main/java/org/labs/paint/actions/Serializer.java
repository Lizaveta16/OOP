package org.labs.paint.actions;

import com.google.gson.*;
import javafx.scene.paint.Color;
import org.labs.paint.shapes.ParentShape;

import java.io.*;
import java.util.ArrayList;

public class Serializer {

    public static void serialize(ArrayList<ParentShape> shapes, File file) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Color.class, new ColorSerializer())
                .create();
        try {
            FileWriter fileWriter = new FileWriter(file, false);
            JsonObject shapeClass = new JsonObject();
            for (ParentShape shape : shapes) {
                shapeClass.addProperty("class", shape.getClass().getName());
                fileWriter.write(gson.toJson(shapeClass) + "\n");
                fileWriter.write(gson.toJson(shape) + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<ParentShape> deserialize(File file) {
        ArrayList<ParentShape> shapesList = new ArrayList<>();
        GsonBuilder builder = new GsonBuilder()
                .registerTypeAdapter(Color.class, new ColorDeserializer());
        Gson gson = builder.create();
        String figureType = null;
        ParentShape shape;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            int k = 1;
            JsonStreamParser jsonParser = new JsonStreamParser(reader);
            while (jsonParser.hasNext()) {
                JsonElement e = jsonParser.next();
                if (e.isJsonObject()) {
                    if (k % 2 != 0) {
                        figureType = e.getAsJsonObject().get("class").getAsString();
                    } else {
                        shape = (ParentShape) gson.fromJson(e, Class.forName(figureType));
                        shapesList.add(shape);
                    }
                }
                k++;
            }
            DrawingHistory.setDrawnShapesCount(shapesList.size());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return shapesList;
    }
}
