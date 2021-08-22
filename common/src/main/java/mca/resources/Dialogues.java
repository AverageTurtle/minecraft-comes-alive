package mca.resources;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonElement;

import java.util.Random;
import mca.MCA;
import mca.resources.data.Question;
import net.minecraft.resource.JsonDataLoader;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;

public class Dialogues extends JsonDataLoader {
    protected static final Identifier ID = new Identifier(MCA.MOD_ID, "dialogues");

    private Random random = new Random();

    private static Dialogues INSTANCE;

    public static final Dialogues getInstance() {
        return INSTANCE;
    }

    private final Map<String, List<Question>> questions = new HashMap<>();

    public Dialogues() {
        super(Resources.GSON, "dialogues");
        INSTANCE = this;
    }

    public Dialogues(Gson gson, String dataType) {
        super(gson, dataType);
    }

    @Override
    protected void apply(Map<Identifier, JsonElement> data, ResourceManager manager, Profiler profiler) {
        questions.clear();
        data.forEach(this::loadDialogue);
    }

    private void loadDialogue(Identifier id, JsonElement element) {
        Question[] questions = Resources.GSON.fromJson(element, Question[].class);

        for (Question q : questions) {
            this.questions.computeIfAbsent(q.getId(), x -> new LinkedList<>());
            this.questions.get(q.getId()).add(q);
        }
    }

    public Question getQuestion(String i) {
        List<Question> questions = this.questions.get(i);
        return questions.get(random.nextInt(questions.size()));
    }
}
