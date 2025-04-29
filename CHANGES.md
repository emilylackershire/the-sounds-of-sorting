## Comments made 

You are on the right track! Remember you can always run mvn checkstyle:check to get a list of style violations. Aim for less than 3 violations for an E.

If you are aiming for an E on the final submission, highlight the bars that are being swapped throughout the sorting algorithm and include the sound from the scales (as mentioned on the grading rubric above).

The program doesn't run the sorting visualization. On the other hand, it looks like you made a significant progress with the sorting algorithms.

## Changes made

I knew this was issues in the run function, so I started working there. I wasn't calling the events sort, i was just making an empty list so I did this, which led to an error with selection sort. The error is due to how I did the lists, and I took some casting of list away which was a mistake.