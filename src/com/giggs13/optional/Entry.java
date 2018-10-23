package com.giggs13.optional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Entry {
    public static void main(String[] args) {
        Optional<String> optional_1 = Optional.empty();

        String str = "value";
        Optional<String> optional_2 = Optional.of(str);

        Optional<String> optional_3 = Optional.ofNullable(str);

        List<String> list_ = null;
        List<String> listOfNullable = Optional.ofNullable(list_).orElseGet(Collections::emptyList);
        System.out.println(listOfNullable);
        List<String> list = Stream.of("one", "two", "three").collect(Collectors.toList());
        List<String> listOf = Optional.of(list).orElseGet(Collections::emptyList);
        System.out.println(listOf);

        Optional<User> user = Optional.ofNullable(getUser());
        String userStreet = user
                .map(User::getAddress)
                .map(User.Address::getStreet)
                .orElse("not specified");
        System.out.println(userStreet);
    }

    private static User getUser() {
        User.Address address = new User.Address("Dnipro");
        return new User(address);
    }

    private static class User {
        private Address address;

        public User(Address address) {
            this.address = address;
        }

        public Address getAddress() {
            return address;
        }

        private static class Address {
            private String street;

            public Address(String street) {
                this.street = street;
            }

            public String getStreet() {
                return street;
            }
        }
    }
}
