package com.example.calculatormasterclass;

public class CalculatorModel {
    private int firstArg;
    private int secondArg;

    private StringBuilder inputStr = new StringBuilder();

    private int actionSelected;

    private State state;

    private enum State {
        firstArgInput,
        operationSelected,
        secondArgInput,
        resultShow
    }

    public CalculatorModel() {
        state = State.firstArgInput;
    }

    public void onNumPressed(int buttonId) {

        if (state == State.resultShow) {
            state = State.firstArgInput;
            inputStr.setLength(0);
        }

        if (state == State.operationSelected) {
            state = State.secondArgInput;
            inputStr.setLength(0);
        }

        if (inputStr.length() < 9) {
                if(R.id.zero == buttonId) {
                    if (inputStr.length() != 0) {
                        inputStr.append("0");
                    }
                }
                if(R.id.one == buttonId) {
                    inputStr.append("1");
                }
                if (R.id.two == buttonId) {
                    inputStr.append("2");
                }
                if (R.id.three == buttonId) {
                    inputStr.append("3");
                }
                if(R.id.four == buttonId) {
                    inputStr.append("4");
                }
                if(R.id.five == buttonId) {
                    inputStr.append("5");
                }
                if(R.id.six == buttonId) {
                    inputStr.append("6");
                }
                if(R.id.seven == buttonId) {
                    inputStr.append("7");
                }
                if (R.id.eight == buttonId) {
                    inputStr.append("8");
                }
                if (R.id.nine == buttonId) {
                    inputStr.append("9");
                }
            }
        }


    public void onActionPressed(int actionId) {
        if (actionId == R.id.equals && state == State.secondArgInput && inputStr.length() > 0) {
            secondArg = Integer.parseInt(inputStr.toString());
            state = State.resultShow;
            inputStr.setLength(0);
                if(R.id.plus == actionSelected) {
                    inputStr.append(firstArg + secondArg);
                }
                if(R.id.minus == actionSelected) {
                    inputStr.append(firstArg - secondArg);
                }
                if(R.id.multiply == actionSelected) {
                    inputStr.append(firstArg * secondArg);
                }
                if(R.id.division == actionSelected) {
                    inputStr.append(firstArg / secondArg);
                }

        } else if (inputStr.length() > 0 && state == State.firstArgInput && actionId != R.id.equals) {
            firstArg = Integer.parseInt(inputStr.toString());
            state = State.operationSelected;
            actionSelected = actionId;
        }
    }

    public String getText() {
        StringBuilder str = new StringBuilder();
        switch (state) {
            default:
                return inputStr.toString();
            case operationSelected:
                return str.append(firstArg).append(' ')
                        .append(getOperationChar())
                        .toString();
            case secondArgInput:
                return str.append(firstArg).append(' ')
                        .append(getOperationChar())
                        .append(' ')
                        .append(inputStr)
                        .toString();
            case resultShow:
                return str.append(firstArg).append(' ')
                        .append(getOperationChar())
                        .append(' ')
                        .append(secondArg)
                        .append(" = ")
                        .append(inputStr.toString())
                        .toString();
        }
    }

    private char getOperationChar() {

            if(R.id.plus == actionSelected) {
                return '+';
            }
            if(R.id.minus == actionSelected) {
                return '-';
            }
            if(R.id.multiply == actionSelected) {
                return '*';
            }
            //if(R.id.division == actionSelected){
            else{
                return '/';
            }
    }

    public void reset() {
        state = State.firstArgInput;
        inputStr.setLength(0);
    }
}

