package org.kwalat.patronage.playground.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.naturalOrder;

/**
 * @author Qba Walat
 * created on 19/09/2018
 */
public class StreamsPlayground {

    public static void main(String[] args) {
        String names = "Josh, Juliet, Kane, Arrrnold, Zephyr, Gilroy";
        List<String> kids = splitToList(names, ", ");
        kids.sort(naturalOrder());
        printListElementsThatStartWith("J", kids);
        printListElementsInUppercase(kids);

        List<Integer> number = Arrays.asList(16, 2, 323, 4, 0, 1505, 4, 3, 2);
        System.out.println(number.stream().max(Integer::compareTo));

    }

    private static List<String> splitToList(String names, String separator) {
        return Arrays.stream(names.split(separator))
                .collect(Collectors.toList());
    }

    private static void printListElementsThatStartWith(String startSequence, List<String> list) {
        list.stream()
                .filter(name -> name.startsWith(startSequence))
                .forEach(System.out::println);
    }


    private static void printListElementsInUppercase(List<String> kids) {
        kids.stream().map(String::toUpperCase).forEach(System.out::println);
    }

}

