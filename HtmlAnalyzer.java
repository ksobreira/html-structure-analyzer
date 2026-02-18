import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

public class HtmlAnalyzer {

    public static void main(String[] args) {
        if (args.length == 0) {

            return;
        }

        try {
            List<String> lines = fetchContent(args[0]);
            analyzeDepth(lines);
        } catch (IOException e) {
            System.out.println("URL connection error");
        }
    }

    private static List<String> fetchContent(String urlString) throws IOException {
        List<String> lines = new ArrayList<>();
        URL url = URI.create(urlString).toURL();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String trimmedLine = line.trim();
                if (!trimmedLine.isEmpty()) {
                    lines.add(trimmedLine);
                }
            }
        }
        return lines;
    }

    private static void analyzeDepth(List<String> lines) {
        Stack<String> stack = new Stack<>();
        String deepestText = "";
        int maxDepth = -1;

        for (String line : lines) {
            if (line.startsWith("</")) {
                String tag = line.substring(2, line.length() - 1).split(" ")[0];
                if (stack.isEmpty() || !stack.peek().equals(tag)) {
                    System.out.println("malformed HTML");
                    return;
                }
                stack.pop();

            } else if (line.startsWith("<")) {
                String tag = line.substring(1, line.length() - 1).split(" ")[0];
                stack.push(tag);

            } else {
                if (stack.size() > maxDepth) {
                    maxDepth = stack.size();
                    deepestText = line;
                }
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("malformed HTML");
        } else if (deepestText.isEmpty() && maxDepth == -1) {
            return;
        } else {
            System.out.println(deepestText);
        }
    }
}