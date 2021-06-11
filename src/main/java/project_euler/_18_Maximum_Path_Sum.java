package project_euler;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class _18_Maximum_Path_Sum {
  public static void main(String[] args) {
    String fileName =
        System.getProperty("user.dir")
            + "\\src\\main\\java\\project_euler\\_18_MaximumPathInput.txt";
    // read file into stream, try-with-resources
    List<Node> pyramid = new ArrayList<>();
    String[] current;
    String[] predecessors = new String[0];
    String[] descendants = new String[0];
    Map<Integer, String[]> rawPyramid = new HashMap<>();
    AtomicInteger i = new AtomicInteger(0);
    try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
      stream.forEach(
          line -> {
            String[] numbers = line.split(" ");
            rawPyramid.put(i.get(), numbers);
            i.incrementAndGet();
          });

    } catch (IOException e) {
      e.printStackTrace();
    }
    for (Map.Entry<Integer, String[]> entry : rawPyramid.entrySet()) {
      if (entry.getKey() == 0) {
        current = entry.getValue();
        addToPyramidStructure(current, predecessors, descendants, pyramid);
      } else {
        current = entry.getValue();
        predecessors = rawPyramid.get(entry.getKey() - 1);
        descendants = rawPyramid.get(entry.getKey() + 1);
        addToPyramidStructure(current, predecessors, descendants, pyramid);
      }
    }
  }

  private static void addToPyramidStructure(
      String[] current, String[] predecessors, String[] descendants, List<Node> pyramid) {
    for (int i = 0; i < current.length; i++) {
      Node currentNode = new Node();
      currentNode.setCurrent(Integer.parseInt(current[i]));
      if(predecessors.length != 0) {
          if (i == 0) {
              currentNode.addPredecessor(new Node(Integer.parseInt(predecessors[i])));
          } else if (i == predecessors.length) {
              currentNode.addPredecessor(new Node(Integer.parseInt(predecessors[i - 1])));
          } else {
              currentNode.addPredecessor(new Node(Integer.parseInt(predecessors[i])));
              currentNode.addPredecessor(new Node(Integer.parseInt(predecessors[i - 1])));
          }
      }
      if(descendants.length != 0) {
              currentNode.addDescendants(new Node(Integer.parseInt(descendants[i])));
              currentNode.addDescendants(new Node(Integer.parseInt(descendants[i + 1])));
      }
        pyramid.add(currentNode);
    }
  }

//  private static Node getExistingNode(String value, Set<Node> existingPyramid) {
//      for(Node node : existingPyramid) {
//          if(node.getCurrent() == Integer.parseInt(value)) {
//              return node;
//          } else if()
//      }
//  }

  @Getter
  @Setter
  @NoArgsConstructor
  static class Node {
    private List<Node> directPredecessors = new ArrayList<>();
    private Integer current;
    private List<Node> directDescendants = new ArrayList<>();

    public Node(Integer current) {
      this.current = current;
    }

    public void addPredecessor(Node node) {
      this.directPredecessors.add(node);
    }

    public void addDescendants(Node node) {
      this.directDescendants.add(node);
    }

      @Override
      public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Node node = (Node) o;
          return Objects.equals(current, node.current);
      }

      @Override
      public int hashCode() {
          return Objects.hash(current);
      }
  }
}
