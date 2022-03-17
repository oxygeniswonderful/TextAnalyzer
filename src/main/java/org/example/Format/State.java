package org.example.Format;

import java.util.Objects;

public class State {

    private String state;

    public State(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;
        State state1 = (State) o;
        return Objects.equals(state, state1.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state);
    }

    @Override
    public String toString() {
        return "State{" +
                "state='" + state + '\'' +
                '}';
    }
}
