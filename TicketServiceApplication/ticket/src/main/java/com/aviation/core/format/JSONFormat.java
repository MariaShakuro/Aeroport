package com.aviation.core.format;
//Можно Jackson/Gson
import com.fasterxml.jackson.core.JsonParseException;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class JSONFormat {

    public static List<> readTicketInfoFromDB(String filePath) throws FileNotFoundException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
        Gson gson = gsonBuilder.create();

        Map<String, List<JsonObject>> jsonMap;
        try {
            jsonMap = gson.fromJson(new FileReader(filePath), new TypeToken<Map<String, List<JsonObject>>>() {}.getType());
        } catch (JsonSyntaxException | JsonIOException e) {
            System.out.println("Ошибка чтения JSON: " + e.getMessage());
            return new ArrayList<>();
        }

        List<> bikes = new ArrayList<>();
        if (jsonMap != null && jsonMap.containsKey("bikes")) {
            List<JsonObject> jsonBikes = jsonMap.get("bikes");

            for (JsonObject jsonBike : jsonBikes) {
                int id = jsonBike.get("id").getAsInt();
                Date date = gson.fromJson(jsonBike.get("date"), Date.class);
                String type = jsonBike.get("type").getAsString();
                String model = jsonBike.get("model").getAsString();
                double price = jsonBike.get("price").getAsDouble();
                double max_speed = jsonBike.get("max_speed").getAsDouble();

                AbstractVelo bike;
                if ("Road".equalsIgnoreCase(type) || "Шоссейный велосипед".equalsIgnoreCase(type)) {
                    bike = new RoadVelo(id, date, type, model, price, max_speed);
                } else if ("Mountain".equalsIgnoreCase(type) || "Горный велосипед".equalsIgnoreCase(type)) {
                    bike = new MountainVelo(id, date, type, model, price, max_speed);
                } else {
                    System.out.println("Неизвестный тип: " + type);
                    continue;
                }
                bikes.add(bike);
            }
        } else {
            System.out.println("Нет информации о байках в JSON.");
        }

        return bikes;
    }

    private static class DateDeserializer implements JsonDeserializer<Date> {
        private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        @Override
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
            try {
                return dateFormat.parse(json.getAsString());
            } catch (ParseException e) {
                throw new JsonParseException("Невозможно разобрать дату: " + json.getAsString(), e);
            }}

    public class JSONWriter {

        public static void writeTicketIntoToJSONFile(String filePath, List<> bikes) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setPrettyPrinting();
            gsonBuilder.registerTypeAdapter(Date.class, new DateSerializer());
            gsonBuilder.registerTypeAdapter(AbstractVelo.class, new AbstractVeloSerializer());
            Gson gson = gsonBuilder.create();

            Map<String, List<>> jsonMap = new HashMap<>();
            jsonMap.put("bikes", bikes);

            try (FileWriter writer = new FileWriter(filePath)) {
                gson.toJson(jsonMap, writer);
                System.out.println("Данные успешно записаны в " + filePath);
            } catch (IOException e) {
                System.out.println("Ошибка записи JSON: " + e.getMessage());
            }
        }

        private static class DateSerializer implements JsonSerializer<Date> {
            private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            @Override
            public JsonElement serialize(Date src, java.lang.reflect.Type typeOfSrc, JsonSerializationContext context) {
                return new JsonPrimitive(dateFormat.format(src));
            }
        }

        private static class AbstractVeloSerializer implements JsonSerializer<> {
            @Override
            public JsonElement serialize(AbstractVelo src, java.lang.reflect.Type typeOfSrc, JsonSerializationContext context) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("id", src.getID());
                jsonObject.addProperty("date", new SimpleDateFormat("yyyy-MM-dd").format(src.getDATE()));
                jsonObject.addProperty("type", src.getTYPE());
                jsonObject.addProperty("model", src.getMODEL());
                jsonObject.addProperty("price", src.getPRICE());
                jsonObject.addProperty("max_speed", src.getMAX_SPEED());
                return jsonObject;
            }
        }
    }

}

