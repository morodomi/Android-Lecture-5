##Author
Masahiro Morodomi &lt;morodomi at gmail.com&gt;

##Description

Android Lecture 5 for Developers.

In this Lecture, you will learn how to process asynchronously.

##Requirements
 * Eclipse IDE for Java Developers
 * Android SDK
 * Android 2.1 or higher

##Questions
 * Add a progress dialog during calculation in background

    <pre>
        // create dialog
        public Dialog onCreateDialog(int id);
        // showing dialog
        public final void showDialog(int id);
        // removing dialog
        public final void removeDialog(int id);
    </pre>

 * Change the calculation with number from text input
 * Add another AsyncTask class to calculate factorial of the parameter.
 * Change AsyncTask to Thread class (This question may take more than 30 min)
 
    <pre>
    // do something in foreground
    Handler handler = new Handler();
    new Thread(new Runnable() {

        @Override
        public void run() {
           // do something here in background
           hander.post(new Runnable() {

               @Override
               public void run() {
                   // do something in foreground
               }
           });
        }
    })
    .start();
    </pre>

##License
    Copyright (c) on 2012, Masahiro Morodomi

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
    implied.

    See the License for the specific language governing permissions and
    limitations under the License.
