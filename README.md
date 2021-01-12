For this application i've used kotlin + mvvm + retrofit + databinding.
For navigation i've tried the android.arch and i've really liked the process (nice and clean).
I believe that i could've polished all ListViewHolder (duplication) and could try some abstration to reduce the fragmentation and add some reusability,
but the adapter layer complicate this approach and that's why i didn't try (for now).

In terms of organization, i have split in packages (model, view), for the view package i've split in 3 parts, adapter, base and ui, where in ui each "page"
gets a new package. For the model package, i've simplified writing all "pojos" inside ApiResponse, but normally i would create each "pojo" in one file
(i really liked my approach in this project because i feel that the structure is more clean, without 20 files defining objects).

Of all plus points to accomplish, i've just explored the pagination because i could just dedicate my weekend time to this challenge.

As you can see, i don't have lots of experience with mvvm or even databinding but i really want to learn more and i can adapt and learn really fast ;)